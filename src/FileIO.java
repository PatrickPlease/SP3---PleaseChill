import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public static void saveUserData(User newUser) {
    }

    public ArrayList<String> readUserData(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return data;
    }

    public class UserDataSaver {
        public static void saveUserData(List<User> users) {
            try {
                FileWriter writer = new FileWriter("data/UserData.txt");
                writer.write("Username, Password" + "\n");
                for (User user : users) {
                    String textToSave = user.getUsername() + "," + user.getPassword();
                    writer.write(textToSave + "\n");
                }
                writer.close();
                System.out.println("User data saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }}