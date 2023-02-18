import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public abstract class WordCount {

    public static void wordsCount() {
        File file = new File("words.txt");
        Map<String,Integer> result = new HashMap<>();
        Integer count = 1;

        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] splitedLine = line.split(" ");
                for (int i = 0; i < splitedLine.length; i++) {
                    if (result.containsKey(splitedLine[i])) {
                        result.put(splitedLine[i],result.get(splitedLine[i]) + 1);
                    }
                    else {
                        result.put(splitedLine[i],count);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result = CustomComparator.sortByValues(result);
        Object[] allWords = result.keySet().toArray();
        Object[] values = result.values().toArray();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(allWords[i] + " " + values[i]);
        }

    }
}
