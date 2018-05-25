package WoW_DBP.WoWDataClasses.AuctionDataStatus;

import java.util.ArrayList;
import java.util.Map;

public class AuctionDataStatus {
    private ArrayList<File> files;

    public AuctionDataStatus(ArrayList<File> files) {
        this.files = files;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "AuctionDataStatus{" +
                "files=" + files +
                '}';
    }
}
