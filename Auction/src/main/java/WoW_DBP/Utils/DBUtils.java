package WoW_DBP.Utils;

import WoW_DBP.Repository.RealmRepository;
import WoW_DBP.Repository.URLRepository;
import WoW_DBP.WoWDataClasses.AuctionDataStatus.AuctionDataStatus;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DBUtils {

    /** бежим по всем URL и по каждому скачеваем JSON и записываем в новый .txt*/
    public static void dataBuilder() throws IOException{
        Gson gson = new Gson();
        Map<String,AuctionDataStatus> realmStatus = new LinkedHashMap<String, AuctionDataStatus>();


        /**допилить*/
        File rStatus = new File(".\\rStatus.txt");
        if (!rStatus.exists()) {
            rStatus.createNewFile();
            System.out.println("File: rStatus.txt successfully created.");
        }else {
            BufferedReader reader = new BufferedReader(new FileReader(".\\rStatus.txt"));

            try {
                String line;
                for (RealmRepository realm:RealmRepository.values()) {
                    if ((line = reader.readLine()) != null) {
                        AuctionDataStatus auctionDataStatus = gson.fromJson(JsonUtils.getJsonFromTxt(line), AuctionDataStatus.class);
                        realmStatus.put(realm.getRealmName(), auctionDataStatus);
                    }
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }


        for (RealmRepository realm:RealmRepository.values()){

            AuctionDataStatus auctionDataStatus = gson.fromJson
                    (JsonUtils.getJsonFromURL
                                    ("https://eu.api.battle.net/wow/auction/data/"+realm.getRealmName()+"?locale=en_GB&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4")
                            ,AuctionDataStatus.class);

            if (!realmStatus.containsKey(realm.getRealmName())||!realmStatus.get(realm.getRealmName()).equals(auctionDataStatus)) {
                realmStatus.put(realm.getRealmName(), auctionDataStatus);
                System.out.println(realm.getRealmName() + " realm status updated.");

                File file = new File(".\\" + realm.getRealmName() + ".txt");
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
        }


        /**допилить*/
        for (RealmRepository realm:RealmRepository.values()) {
            try {
                FileUtils.write(
                        rStatus,
                        gson.toJson(realmStatus.get(realm.getRealmName()))+"\n",
                        "UTF-8",
                        true);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            System.out.println("File: rStatus.txt successfully filled with data.");
        }

    }
}
