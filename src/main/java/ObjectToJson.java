import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class ObjectToJson {


    public static void usersToJson() throws IOException {
        List<User> allUsers = new ArrayList<>();
        File file = new File("users.txt");
        try (InputStream fis = new FileInputStream(file);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String users = scanner.nextLine();
                if (! users.equals("name age")) {
                    String[] fields = users.split(" ");
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    User user = new User();
                    user.setName(name);
                    user.setAge(age);
                    allUsers.add(user);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(allUsers);

        OutputStream fos = new FileOutputStream("Users.json");
        fos.write(toJson.getBytes());
    }


}
