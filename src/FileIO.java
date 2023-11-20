import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

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

    public static void saveUserData(ArrayList<User> Users) {
        try {
            FileWriter writer = new FileWriter("data/UserData.txt");
            writer.write("Username, Password" + "\n");
            for (User c : Users) {
                String textTosave = c.getUsername() + "," + c.getPassword();
                writer.write(textTosave + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Something is wrong with the Datafile");
        }

    }
}