import WoW_DBP.Repository.RealmRepository;
import WoW_DBP.Utils.DBUtils;
import WoW_DBP.WoWDataClasses.AuctionDataStatus.AuctionDataStatus;
import WoW_DBP.WoWDataClasses.AuctionDataStatus.File;
import WoW_DBP.WoWDataClasses.AuctionHouse.AuctionHouse;
import WoW_DBP.Repository.URLRepository;
import WoW_DBP.Utils.JsonUtils;
import WoW_DBP.Utils.PMUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws IOException{
        Gson gson = new Gson();

        DBUtils.dataBuilder();
/*        for (RealmRepository realm: RealmRepository.values()){
            AuctionHouse auctionHouse = gson.fromJson(JsonUtils.getJsonFromTxt(realm.getRealmName()), AuctionHouse.class);
            PMUtils.minPrice(242,auctionHouse);
        }*/
/*        Map<String,Long> realmStatus = new LinkedHashMap<String, Long>();

        realmStatus = DBUtils.dataBuilder(realmStatus);

        System.out.println(realmStatus);*/

    }
}