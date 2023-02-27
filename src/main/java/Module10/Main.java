package Module10;

import Module10.FrequencyCounter.WordFrequencyCounter;
import Module10.PhoneNumber.FileReader;
import Module10.PhoneNumber.PhoneNumberValidator;


import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        FileReader fr =new FileReader("C:\\IdeaProjects\\HomeTaskModule10\\untitled\\src\\main\\java\\Module10\\PhoneNumber\\file.txt");
        Queue<String> queue= fr.reading();
        for (String result:queue) {
            PhoneNumberValidator.validator(result);
        }
        queue.clear();

        WordFrequencyCounter wfc=new WordFrequencyCounter("C:\\IdeaProjects\\HomeTaskModule10\\untitled\\src\\main\\java\\Module10\\FrequencyCounter\\words.txt");
        wfc.wordsCounter();



    }
}

