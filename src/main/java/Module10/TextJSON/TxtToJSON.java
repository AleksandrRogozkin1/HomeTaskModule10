package Module10.TextJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtToJSON {
    public  String saveJson(String pathFileReader, String pathFileWriter)  {
        String jsonString = "";
        try (PrintWriter out = new PrintWriter(new FileWriter(pathFileWriter))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonString = gson.toJson(readerFile(pathFileReader));
            out.write(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  jsonString;
    }
    public static Object readerFile( String pathFileReader) throws IOException {
        File file = new File(pathFileReader);
        InputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        User user;
        ArrayList list = new ArrayList<>();
        int count = 0;

        while (scanner.hasNext()) {
            count++;
            String[] str = scanner.nextLine().split(" ");
            if (count > 1) {
                list.add(user = new User(str[0], Integer.valueOf(str[1])));
            }
        }
        fis.close();
        scanner.close();
        return list;
    }
}
