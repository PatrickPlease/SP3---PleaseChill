import java.util.ArrayList;

public class StreamingService {
    CreateAccount newAccount;
    Category newCategory;
    Watchlist list;
    FileIO io;
    private TextUI ui = new TextUI();
    static ArrayList<User> users;



    public void setup() {
        ui.displayMessage("Welcome to PleaseChill, your favorite streaming platform");

        int choice = Integer.parseInt(ui.getInput("Press 1 to Login, Press 2 to Create an account"));

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                CreateAccount.createUser();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                setup();
                break;
        }
    }

    public void login() {
        ArrayList<String> data = io.readUserData("data/UserData.txt");

        String username = ui.getInput("Enter your username: ");
        String password = ui.getInput("Enter your password: ");

        User user = findUser(username, password);
        if (user != null) {
            ui.displayMessage("Login successful. Welcome back, " + user.getUsername() + "!");

        } else {
            ui.displayMessage("Invalid username or password. Please try again.");
            login();
        }
    }

    private User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Media searchByName(){
        return null;
    }

    public ArrayList<Media> searchByCategory(){
        return null;
    }

    public Media searchByYear(){}

    public void logOut(){}

    void runStreamingService(){}

    public void moveToWatchList(){}
}


// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram