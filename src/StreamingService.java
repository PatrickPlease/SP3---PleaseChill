import java.util.ArrayList;

public class StreamingService {
    CreateAccount newAccount;
    Category newCategory;
    Watchlist list;
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    private List<TvShow> tvShows;
    private List<Movies> movies;
    static ArrayList<User> users = new ArrayList<>();


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

        ui.displayMessage("============================================= \n");
        int mainpage = Integer.parseInt(ui.getInput(" 1. Search \n 2. Movies \n 3. Series \n 4. Log out"));
        switch (mainpage) {
            case 1:
                searchByName();
                break;
            case 2:
                ui.displayMessage("============================================= \n");
                int moviepage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
                switch(moviepage) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        ui.displayMessage("Invalid choice. Please try again.");
                        break;

                }

                break;
            case 3:
                int seriespage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
                switch(seriespage) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        ui.displayMessage("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 4:
                ui.displayMessage("Logout");
                setup();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
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