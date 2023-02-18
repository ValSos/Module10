import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class NumberValidator {

    public static void checkNumber(String fileName) {
        File file = new File(fileName);
        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String pattern = "[(][0-9]{3}[)]\\s[0-9]{3}[-][0-9]{4}";  //(xxx) xxx-xxxx
                String pattern2 = "[0-9]{3}[-][0-9]{3}[-][0-9]{4}"; //xxx-xxx-xxxx
                Pattern ptrn = Pattern.compile(pattern);
                Pattern ptrn2 = Pattern.compile(pattern2);
                Matcher matcher = ptrn.matcher(line);
                Matcher matcher2 = ptrn2.matcher(line);
                if (matcher.find() || matcher2.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
