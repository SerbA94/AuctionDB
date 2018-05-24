import WoW_DBP.AuctionHouse.Auction;
import WoW_DBP.AuctionHouse.AuctionHouse;
import WoW_DBP.Repository.URLRepository;
import WoW_DBP.Utils.DBUtils;
import WoW_DBP.Utils.JsonUtils;
import WoW_DBP.Utils.PMUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        Gson gson = new Gson();

      //  DBUtils.dataBuilder();

        for (URLRepository realm: URLRepository.values()){
            AuctionHouse auctionHouse = gson.fromJson(JsonUtils.getJsonFromTxt(realm.name()), AuctionHouse.class);
            PMUtils.minPrice(124105L,auctionHouse);
        }


        
    }
}