package WoW_DBP.AuctionHouse;

public class Auction {
    private Long auc;
    private Long item;
    private String owner;
    private String ownerRealm;
    private Long bid;
    private Long buyout;
    private Integer quantity;
    private String timeLeft;
    private Integer rand;
    private Long seed;
    private Integer context;


    public Auction(Long auc, Long item, String owner, String ownerRealm, Long bid, Long buyout, Integer quantity, String timeLeft, Integer rand, Long seed, Integer context) {
        this.auc = auc;
        this.item = item;
        this.owner = owner;
        this.ownerRealm = ownerRealm;
        this.bid = bid;
        this.buyout = buyout;
        this.quantity = quantity;
        this.timeLeft = timeLeft;
        this.rand = rand;
        this.seed = seed;
        this.context = context;
    }

    public Long getAuc() {
        return auc;
    }

    public void setAuc(Long auc) {
        this.auc = auc;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerRealm() {
        return ownerRealm;
    }

    public void setOwnerRealm(String ownerRealm) {
        this.ownerRealm = ownerRealm;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getBuyout() {
        return buyout;
    }

    public void setBuyout(Long buyout) {
        this.buyout = buyout;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Integer getRand() {
        return rand;
    }

    public void setRand(Integer rand) {
        this.rand = rand;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public Integer getContext() {
        return context;
    }

    public void setContext(Integer context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "\n Auction{" +
                "auc=" + auc +
                ", item=" + item +
                ", owner='" + owner + '\'' +
                ", ownerRealm='" + ownerRealm + '\'' +
                ", bid=" + bid +
                ", buyout=" + buyout +
                ", quantity=" + quantity +
                ", timeLeft='" + timeLeft + '\'' +
                ", rand=" + rand +
                ", seed=" + seed +
                ", context=" + context +
                '}';
    }
}
