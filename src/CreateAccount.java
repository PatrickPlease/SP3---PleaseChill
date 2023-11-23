import java.util.Scanner;

public class CreateAccount {
    private static TextUI ui = new TextUI();
    public static void createUser() {
        Scanner scanner = new Scanner(System.in);
        ui.displayMessage("Welcome. Please enter a username");

        String username = scanner.nextLine();
        ui.displayMessage("Please enter a password");
        String password = scanner.nextLine();

        try {
            User newUser = new User(username, password);
            User.addUser(newUser);
            FileIO.saveUserData(newUser);
            ui.displayMessage( "New user added. Welcome");

        } catch (IllegalArgumentException e) {
            ui.displayMessage("Your input was not valid. Please try again");

        }
        public boolean createUser(String username, String password){

        }
        public boolean addUser(new user(username,password)){

        }
}