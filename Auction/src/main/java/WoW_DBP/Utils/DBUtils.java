package WoW_DBP.Utils;

import WoW_DBP.Repository.RealmRepository;
import WoW_DBP.Repository.URLRepository;
import WoW_DBP.WoWDataClasses.AuctionDataStatus.AuctionDataStatus;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DBUtils {

    /** бежим по всем URL и по каждому скачеваем JSON и записываем в новый .txt*/
    public static Map<String,Long> dataBuilder(Map<String,Long> realmStatus) throws IOException{
        Gson gson = new Gson();
        for (RealmRepository realm:RealmRepository.values()){
            AuctionDataStatus auctionDataStatus = gson.fromJson
                    (JsonUtils.getJsonFromURL
                                    ("https://eu.api.battle.net/wow/auction/data/"+realm.getRealmName()+"?locale=en_GB&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4")
                            ,AuctionDataStatus.class);
            if (!realmStatus.containsKey(realm.getRealmName())||!realmStatus.get(realm.getRealmName()).equals(auctionDataStatus.getFiles().get(0).getLastModified())) {
                realmStatus.put(realm.getRealmName(), auctionDataStatus.getFiles().get(0).getLastModified());
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



/*        for (URLRepository url: URLRepository.values()){
            File file = new File(".\\"+url.name()+".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File: " + url.name() + ".txt successfully created.");
            }
            try {
                FileUtils.write(
                        file,
                        JsonUtils.getJsonFromURL(url.getRealmUrl()),
                        "UTF-8",
                        true);
                System.out.println("File: " + url.name() + ".txt successfully filled with data.");
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        }*/

        return realmStatus;
    }

    public static void updateChecker(String realm){
        Gson gson = new Gson();
        AuctionDataStatus auctionDataStatus = gson.fromJson
                (JsonUtils.getJsonFromURL("https://eu.api.battle.net/wow/auction/data/"
                        +realm
                        +"?locale=en_GB&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4")
                        ,AuctionDataStatus.class);
    }
}
