import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public static User readUserData(String username) {
        try (Scanner scanner = new Scanner(new File("data/UserData/" + username + "_UserData.txt"))) {
            if (scanner.hasNextLine()) {
                String password = scanner.nextLine();
                return new User(username, password);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return null;
    }

    public static void saveUserData(User user) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter("data/UserData/" + user.getUsername() + "_UserData.txt", true))) {
            if (user != null) {
                pWriter.println(user.getPassword());
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with the Datafile: " + e.getMessage());
        }
    }

    public static void addToWatchlist(User user, String newWatchlistItem) {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter("data/UserData/" + user.getUsername() + "_UserData.txt", true))) {
            if (user != null) {
                pWriter.println("Watchlist:" + newWatchlistItem);
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with the Datafile: " + e.getMessage());
        }
    }

}