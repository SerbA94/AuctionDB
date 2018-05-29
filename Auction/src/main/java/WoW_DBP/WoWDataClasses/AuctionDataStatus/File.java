package WoW_DBP.WoWDataClasses.AuctionDataStatus;

public class File {
    private String url;
    private long lastModified;

    public File(String url, long lastModified) {
        this.url = url;
        this.lastModified = lastModified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(Long lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "File{" +
                "url='" + url + '\'' +
                ", lastModified=" + lastModified +
                '}';
    }
}
