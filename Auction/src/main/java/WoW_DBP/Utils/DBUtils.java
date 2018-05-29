package WoW_DBP.Utils;

import WoW_DBP.Repository.RealmRepository;
import WoW_DBP.WoWDataClasses.AuctionDataStatus.AuctionDataStatus;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class DBUtils {

    /** Этот метод бежит по всем серверам и в случае необходимости
     *  скачивает актуальные JSON файлы и записывает в .txt
     *  на локальной машине, для более быстрого доступа к данным.*/
    public static void dataBuilder() throws IOException{
        Gson gson = new Gson();
        StringBuilder stringBuilder = new StringBuilder();
        Map<String,AuctionDataStatus> realmStatus = DBUtils.RSMapBuilder();


        for (RealmRepository realm:RealmRepository.values()){

            AuctionDataStatus auctionDataStatus = gson.fromJson
                    (JsonUtils.getJsonFromURL
                                    ("https://eu.api.battle.net/wow/auction/data/"
                                            + realm.getRealmName()
                                            + "?locale=en_GB&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4")
                            ,AuctionDataStatus.class);

            if (realmStatus.get(realm.getRealmName()).getFiles().get(0).getLastModified()!=auctionDataStatus.getFiles().get(0).getLastModified()) {

                realmStatus.put(realm.getRealmName(), auctionDataStatus);
                System.out.println(realm.getRealmName() + " realm status updated.");

                File file = new File("C:\\Users\\realpop\\Desktop\\WoW_AH_DB\\" + realm.getRealmName() + ".txt");
                if (!file.exists()) {
                    file.createNewFile();
                    System.out.println("File: " + realm.getRealmName() + ".txt successfully created.");
                }
                try {
                    FileUtils.write(
                            file,
                            JsonUtils.getJsonFromURL(auctionDataStatus.getFiles().get(0).getUrl()),
                            "UTF-8",
                            false);
                    System.out.println("File: " + realm.getRealmName() + ".txt successfully filled with data.");
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
            stringBuilder.append(gson.toJson(realmStatus.get(realm.getRealmName()),AuctionDataStatus.class));
            stringBuilder.append("\n");
        }
        DBUtils.RSFileWriter(stringBuilder);
    }

    /** Этот метод читает файл с информацией о последних обновлениях серверов,
     *  (если таков файл отсутствует функция его создает)
     *  затем переносит эту информацию в Map по которой в дальнейшем
     *  ведется мониоринг и обновления данных.*/
    public static Map<String,AuctionDataStatus> RSMapBuilder() throws IOException{
        Map<String,AuctionDataStatus> realmStatus = new LinkedHashMap<String, AuctionDataStatus>();
        Gson gson = new Gson();
        File rStatus = new File(".\\rStatus.txt");
        if (!rStatus.exists()) {
            rStatus.createNewFile();
            System.out.println("File: rStatus.txt successfully created.");
            for (RealmRepository realm:RealmRepository.values()){
                ArrayList<WoW_DBP.WoWDataClasses.AuctionDataStatus.File> files = new ArrayList<WoW_DBP.WoWDataClasses.AuctionDataStatus.File>();
                files.add(new WoW_DBP.WoWDataClasses.AuctionDataStatus.File("0",0L));
                realmStatus.put(realm.getRealmName(),new AuctionDataStatus(files));
            }
        }else {
            BufferedReader reader = new BufferedReader(new FileReader(".\\rStatus.txt"));
            try {
                String line;
                for (RealmRepository realm:RealmRepository.values()) {
                    if ((line = reader.readLine()) != null) {
                        AuctionDataStatus auctionDataStatus = gson.fromJson(line, AuctionDataStatus.class);
                        realmStatus.put(realm.getRealmName(), auctionDataStatus);
                    }
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        return realmStatus;
    }

    /** Этот метод записывает окончательный файл с информацией об обновлениях серверов*/
    private static void RSFileWriter(StringBuilder stringBuilder) throws IOException{
        File rStatus = new File(".\\rStatus.txt");
        if (!rStatus.exists()) {
            rStatus.createNewFile();
            System.out.println("File: rStatus.txt successfully created.");
        }
        try {
            FileUtils.write(
                    rStatus,
                    stringBuilder.toString(),
                    "UTF-8",
                    false);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        System.out.println("File: rStatus.txt successfully filled with data.");
    }
}
