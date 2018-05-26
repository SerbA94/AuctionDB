package WoW_DBP.Repository;

public enum RealmRepository {
 /*   GORDUNNI("gordunni"),
    SOULFLAYER("soulflayer"),
    ASHENVALE("ashenvale"),
    AZUREGOS("azuregos"),
    BLACKSCAR("blackscar"),
    BOOTYBAY("booty%20bay"), //Deathweaver
    BOREANTUNDRA("borean%20tundra"),
    DEATHGUARD("deathguard"),
    RAZUVIOUS("razuvious"), //Deepholm
    EVERSONG("eversong"),
    FORDRAGON("fordragon"),
    GALAKROND("galakrond"),
    GOLDRINN("goldrinn"),
    LICHKING("lich%20king"), //Greymane*/
    GROM("grom"), //Thermaplugg
    HOWLINGFJORD("howling%20fjord");

    protected String realmName;

    RealmRepository(String realmName) {
        this.realmName = realmName;
    }

    public String getRealmName() {
        return realmName;
    }

    public void setRealmName(String realmName) {
        this.realmName = realmName;
    }

    @Override
    public String toString() {
        return "RealmRepository{" +
                "realmName='" + realmName + '\'' +
                "} " + super.toString();
    }
}
