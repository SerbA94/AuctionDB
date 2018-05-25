package WoW_DBP.WoWDataClasses.AuctionDataStatus;

public class File {
    private String url;
    private Long lastModified;

    public File(String url, Long lastModified) {
        this.url = url;
        this.lastModified = lastModified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getLastModified() {
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
