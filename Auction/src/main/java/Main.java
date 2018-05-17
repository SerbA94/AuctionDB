import WoW_DBP.AuctionHouse.Auction;
import WoW_DBP.AuctionHouse.AuctionHouse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        StringBuilder sb = new StringBuilder();
/*        BufferedReader reader;

        try {
            //urlConnection = (HttpURLConnection) new URL("https://us.api.battle.net/wow/auction/data/medivh?locale=en_US&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4").openConnection();
            // urlConnection = (HttpURLConnection) new URL("https://us.api.battle.net/wow/auction/data/medivh?locale=en_US&apikey=q5h4rm4w22vdxqzuajr3h9vhp547d9t4").openConnection();
            URL url = new URL("http://auction-api-eu.worldofwarcraft.com/auction-data/4c650d6748649b4f91fdec3d2894f9f4/auctions.json");
            reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));


            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

        } catch (IOException e1) {
            System.out.println("URL Connection Error");
        }

        String str = sb.toString();
        AuctionHouse auctionHouseDB = gson.fromJson(str, AuctionHouse.class);
        System.out.println(auctionHouseDB.toString());

        FileWriter writer = new FileWriter("C:\\Users\\realpop\\Desktop\\wow\\test.txt", false);
        try {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\realpop\\Desktop\\wow\\test.txt"));
        try {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        String str = sb.toString();
        AuctionHouse auctionHouse = gson.fromJson(str,AuctionHouse.class);

        System.out.println(auctionHouse);

        Long item = 52200l;
        Long minPrice = 999999999999999999l;
        for (Auction auction:auctionHouse.getAuctions()){
            if (auction.getItem().equals(item)){
                System.out.println(auction.toString());
                if (minPrice>auction.getBuyout()){
                    minPrice = auction.getBuyout();
                }
            }
        }
        System.out.println("minPrice: " + minPrice/10000);
/*
        for (Lot lot: auctionHouse.getLots()){
            System.out.println(lot.getAuc());
        }
*/


    }
}
