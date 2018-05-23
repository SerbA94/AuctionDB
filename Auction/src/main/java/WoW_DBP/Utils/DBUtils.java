package WoW_DBP.Utils;

import WoW_DBP.Repository.URLRepository;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DBUtils {

    /** бежим по всем URL и по каждому скачеваем JSON и записываем в новый .txt*/
    public static void dataBuilder() throws IOException{
        for (URLRepository url: URLRepository.values()){
            File file = new File(".\\"+url.name()+".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File: " + url.name() + ".txt successfully created.");
            }
            try {
                FileUtils.write(
                        file,
                        JsonUtils.getJsonFromURL(url.getRealmUrl()),
                        "UTF-8",
                        true);
                System.out.println("File: " + url.name() + ".txt successfully filled with data.");
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }
}
