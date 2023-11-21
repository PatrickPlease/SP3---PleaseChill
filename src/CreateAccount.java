import java.util.Scanner;

public class CreateAccount {
    private static TextUI ui = new TextUI();

    public static void createUser() {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        while (!DataValidator.isUsernameValid(username)) {
            ui.displayMessage("Username invalid, please try again");
            username = scanner.nextLine();
        }

        String password = scanner.nextLine();
        while (!DataValidator.isPasswordValid(password)) {
            ui.displayMessage("Password invalid, please try again");
            password = scanner.nextLine();
        }

        User newUser = new User(username, password);
        User.addUser(newUser);
        FileIO.saveUserData(newUser);
        ui.displayMessage("New user added. Welcome");
    }
}