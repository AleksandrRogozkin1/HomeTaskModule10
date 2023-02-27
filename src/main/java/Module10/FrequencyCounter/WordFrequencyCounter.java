package Module10.FrequencyCounter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;


public class WordFrequencyCounter {
    private String path;
    private Map<String, Integer> mapWords = new HashMap<>();

    private List<String> allWords;

    public WordFrequencyCounter(String path) {
        this.path = path;
        this.allWords = reading();
    }

    private List<String> reading() {
        List<String> list = new ArrayList<>();
        if (path != null) {
            try (InputStream fileReader = new FileInputStream(path);
                 Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNext()) {
                    String[] temp = scanner.nextLine().split(" ");
                    for (String s : temp) {
                        if (!s.trim().isEmpty()) list.add(s);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void wordsCounter() {
        for (int i = 0; i < allWords.size(); i++) {
            String tempString = allWords.get(i);
            if (!mapWords.containsKey(tempString)) {
                mapWords.put(tempString, 1);
            } else {
                mapWords.put(tempString, mapWords.get(tempString) + 1);
            }
        }

        sort();


    }
    private void sort(){
        Comparator<String> comparator= new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return mapWords.get(o2).compareTo(mapWords.get(o1)) >0 ? 1:-1;
            }
        };
        Map<String,Integer> result=new TreeMap<>(comparator);
        result.putAll(mapWords);
        System.out.println(result);


    }



}
