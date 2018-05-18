import WoW_DBP.AuctionHouse.Auction;
import WoW_DBP.AuctionHouse.AuctionHouse;
import WoW_DBP.JsonUtils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        final String jsonURLGordunni = "http://auction-api-eu.worldofwarcraft.com/auction-data/4c650d6748649b4f91fdec3d2894f9f4/auctions.json";
        final String jsonURLSoulflayer = "http://auction-api-eu.worldofwarcraft.com/auction-data/f9c8b88719864bc9e16af4ba6470bb6a/auctions.json";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();


        AuctionHouse auctionHouseGordunni = gson.fromJson(JsonUtils.getJsonFromURL(jsonURLGordunni), AuctionHouse.class);
        AuctionHouse auctionHouseSoulflayer = gson.fromJson(JsonUtils.getJsonFromURL(jsonURLSoulflayer), AuctionHouse.class);



        minPrice(14970L,auctionHouseGordunni);
        minPrice(14970L,auctionHouseSoulflayer);

        minPrice(95416L,auctionHouseGordunni);
        minPrice(95416L,auctionHouseSoulflayer);



    }
    private static void minPrice(Long item,AuctionHouse auctionHouse){
        Long minPrice = 999999999999999999L;
        for (Auction auction:auctionHouse.getAuctions()){
            if (auction.getItem().equals(item)){
                //System.out.println(auction.toString());
                if (minPrice>auction.getBuyout()){
                    minPrice = auction.getBuyout();
                }
            }
        }
        System.out.println("Item: " + item +" minPrice: " + minPrice/10000+"g. " + auctionHouse.getRealms());
    }
}
