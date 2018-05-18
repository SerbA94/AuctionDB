package WoW_DBP.JsonUtils;


import java.io.*;
import java.net.URL;

public class JsonUtils {

    /**Method returns JsonString from URL*/
    public static String getJsonFromURL(String jsonURL) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader;
        String jsonStr;

        try {
            URL url = new URL(jsonURL);
            reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

        } catch (IOException e1) {
            System.out.println("URL Connection Error");
        }

        jsonStr = sb.toString();

        return jsonStr;
    }


    // Последние 2 методо созданы для тестировки, позже будут удалены
    /**Method write JsonString to .txt file*/
    public static void jsonFileWriter(String jsonStr)throws IOException{
        FileWriter writer = new FileWriter(".\\test.txt", false);
        try {
            writer.write(jsonStr);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**Method returns JsonString from .txt file*/
    public static String getJsonFromTxt()throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(".\\test.txt"));
        StringBuilder sb = new StringBuilder();
        String jsonStr;

        try {

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        jsonStr = sb.toString();
        return jsonStr;
    }

}