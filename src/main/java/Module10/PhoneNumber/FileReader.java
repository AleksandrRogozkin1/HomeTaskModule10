package Module10.PhoneNumber;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FileReader {
    private String sourceString;
    private Queue<String> queue = new ArrayDeque<>();

    public FileReader(String sourceString ){
        this.sourceString=sourceString;

    }
    public Queue<String> reading(){
        if (sourceString != null) {
            try(InputStream fis = new FileInputStream(sourceString);
                Scanner scanner = new Scanner(fis)) {
                while (scanner.hasNext()) {
                    queue.add(scanner.nextLine());
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return queue;
    }


}
