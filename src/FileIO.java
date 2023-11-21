import java.io.*;
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

    public static void saveUserData(User user) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter("UserData.txt"))){

            if (user != null) {
                pWriter.println(user.toString());
                System.out.println("User data saved");
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with the Datafile");
        }
    }
}