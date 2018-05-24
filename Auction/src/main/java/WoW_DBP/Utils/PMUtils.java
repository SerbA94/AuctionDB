package WoW_DBP.Utils;

import WoW_DBP.AuctionHouse.Auction;
import WoW_DBP.AuctionHouse.AuctionHouse;

public class PMUtils {

    /** минимальная цена на item по серверу*/
    public static void minPrice(Long item,AuctionHouse auctionHouse){
        Long minPrice = 999999999999999999L;
        for (Auction auction:auctionHouse.getAuctions()){
            if (auction.getItem().equals(item)){
                if (minPrice>auction.getBuyout()){
                    minPrice = auction.getBuyout();
                }
            }
        }
        if (minPrice != 999999999999999999L){
            System.out.println("Item: " + item + " minPrice: " + minPrice / 10000 + "g. " + auctionHouse.getAuctions().get(0).getOwnerRealm());
        }/*else {
             System.out.println("Lot: "+ item +" is not found." + auctionHouse.getAuctions().get(0).getOwnerRealm());
        }*/
    }

    /** минимальная цена на petSpeciesId по серверу*/
    public static void minPrice(Integer petSpeciesId,AuctionHouse auctionHouse){
        Long minPrice = 999999999999999999L;
        for (Auction auction:auctionHouse.getAuctions()) {
            if (auction.getPetSpeciesId() != null) {
                if (auction.getPetSpeciesId().equals(petSpeciesId)) {

                    if (minPrice > auction.getBuyout()) {
                        minPrice = auction.getBuyout();
                    }
                }
            }
        }
        if (minPrice != 999999999999999999L){
            System.out.println("petSpeciesId: " + petSpeciesId + " minPrice: " + minPrice / 10000 + "g. " + auctionHouse.getAuctions().get(0).getOwnerRealm());
        }/*else {
            System.out.println("Lot: "+ petSpeciesId +" is not found." + auctionHouse.getAuctions().get(0).getOwnerRealm());
        }*/
    }
}
