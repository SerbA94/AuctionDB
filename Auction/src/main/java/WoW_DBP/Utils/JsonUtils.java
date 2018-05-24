package WoW_DBP.Utils;


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

    /**Method returns JsonString from .txt file*/
    public static String getJsonFromTxt(String txtName)throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(".\\"+txtName+".txt"));
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