package WoW_DBP.WoWDataClasses.AuctionHouse;

import java.util.ArrayList;

public class AuctionHouse {
    private ArrayList<Realm> realms;
    private ArrayList<Auction> auctions;

    public AuctionHouse(ArrayList<Realm> realms, ArrayList<Auction> auctions) {
        this.realms = realms;
        this.auctions = auctions;
    }

    public ArrayList<Realm> getRealms() {
        return realms;
    }

    public void setRealms(ArrayList<Realm> realms) {
        this.realms = realms;
    }

    public ArrayList<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(ArrayList<Auction> auctions) {
        this.auctions = auctions;
    }

    @Override
    public String toString() {
        return "AuctionHouse{" +
                "realms=" + realms +
                ", auctions=" + auctions +
                '}';
    }
}
