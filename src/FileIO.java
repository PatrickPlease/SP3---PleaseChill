import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public void readUserData(String path, ArrayList<User> users){
        try (Scanner scan = new Scanner(new File("data/UserData.txt"))) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] userData = line.split(",");

                if (userData.length == 2) {
                    String username = userData[0];
                    String password = userData[1];
                    users.add(new User(username, password));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void saveUserData(User user) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter("data/UserData.txt",true))){

            if (user != null) {
                pWriter.println(user.toString());
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with the Datafile");
        }
    }
}