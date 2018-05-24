package WoW_DBP.Repository;

public enum URLRepository {
    GORDUNNI("http://auction-api-eu.worldofwarcraft.com/auction-data/4c650d6748649b4f91fdec3d2894f9f4/auctions.json"),
    SOULFLAYER("http://auction-api-eu.worldofwarcraft.com/auction-data/f9c8b88719864bc9e16af4ba6470bb6a/auctions.json"),
    ASHENVALE("http://auction-api-eu.worldofwarcraft.com/auction-data/44edbbff72ed9638da2a2ce0aa520037/auctions.json"),
    AZUREGOS("http://auction-api-eu.worldofwarcraft.com/auction-data/6e79a3a8025e9a71ee5eb3bd80df3d4e/auctions.json"),
    BLACKSCAR("http://auction-api-eu.worldofwarcraft.com/auction-data/b6a53e4bbf5d5f7b78b69a419b5d4970/auctions.json"),
    BOOTYBAY("http://auction-api-eu.worldofwarcraft.com/auction-data/34aabefddeef36333f68202636b2a00f/auctions.json"), //Deathweaver
    BOREANTUNDRA("http://auction-api-eu.worldofwarcraft.com/auction-data/cfd8e4ec08837659a70e7ed1863ebcc6/auctions.json"),
    DEATHGUARD("http://auction-api-eu.worldofwarcraft.com/auction-data/4dd7055b110e4cfb3db4c4cc3b3341f3/auctions.json"),
    RAZUVIOUS("http://auction-api-eu.worldofwarcraft.com/auction-data/2b4061f5c4ccaee210e42d78349e041c/auctions.json"), //Deepholm
    EVERSONG("http://auction-api-eu.worldofwarcraft.com/auction-data/dc707dfc35f234b761f913ea5533f9f6/auctions.json"),
    FORDRAGON("http://auction-api-eu.worldofwarcraft.com/auction-data/ed567a8f3b8e59a1bcd14f3b675f0d53/auctions.json"),
    GALAKROND("http://auction-api-eu.worldofwarcraft.com/auction-data/6a60b6f02d575a8f3aa64e065f23be00/auctions.json"),
    GOLDRINN("http://auction-api-eu.worldofwarcraft.com/auction-data/adceab4156acdf40e80180953f3191dc/auctions.json"),
    LICHKING("http://auction-api-eu.worldofwarcraft.com/auction-data/76efd1749b49d06caa9044f54aaaa4b2/auctions.json"), //Greymane
    GROM("http://auction-api-eu.worldofwarcraft.com/auction-data/e9f0eb985d737006a5171dd0380710b1/auctions.json"), //Thermaplugg
    HOWLINGFJORD("http://auction-api-eu.worldofwarcraft.com/auction-data/f6d03d370c3edb1c4477105b6e0fcd9e/auctions.json");

    protected String realmUrl;

    URLRepository(String realmUrl) {
        this.realmUrl = realmUrl;
    }

    public String getRealmUrl() {
        return realmUrl;
    }

    @Override
    public String toString() {
        return "URLRepository{" +
                "realmUrl='" + realmUrl + '\'' +
                "} " + super.toString();
    }
}
