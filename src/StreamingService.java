import java.util.ArrayList;
import java.util.List;



public class StreamingService {
    CreateAccount newAccount;
    Category newCategory = new Category();
    Watchlist list;
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    private List<TvShow> tvShows = new ArrayList<>();
    private List<Movies> movies = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();


    public void setup() {
        users = new ArrayList<>();
        ui.displayMessage("Welcome to PleaseChill, your favorite streaming platform");

        int choice = Integer.parseInt(ui.getInput("Press 1 to Login, Press 2 to Create an account"));

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                ui.displayMessage("You have chosen to create an account");
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
                ui.displayMessage("=============================================\n");
                int searchOption = Integer.parseInt(ui.getInput(" 1. Search by name \n 2. Search by genre \n 3. Search by year \n 4. Return "));
                switch (searchOption) {
                    case 1:
                        String nameSearch = ui.getInput("Enter the name to search: ");
                        newCategory.searchByName(nameSearch, tvShows, movies);
                        break;
                    case 2:
                        String genreSearch = ui.getInput("Enter the genre to search: ");
                        newCategory.searchByGenre(genreSearch, tvShows, movies);
                        break;
                    case 3:
                        String yearSearch = ui.getInput("Enter the year to search: ");
                        newCategory.searchByYear(Integer.parseInt(yearSearch), tvShows, movies);
                        break;
                    case 4: //tilbage til valgmulighederne 1. search 2. movies osv..
                        break;
                    default:
                        ui.displayMessage("Invalid choice. Please try again.");
                        break;
                }
                break;
            case 2:
                ui.displayMessage("============================================= \n");
                int moviepage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
                switch(moviepage) {
                    case 1:
                        MediaApplication.moviesPrinter();
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
                        MediaApplication.tvShowPrinter();

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
        io.readUserData("data/UserData.txt", users);

        String username = ui.getInput("Enter your username: ");
        String password = ui.getInput("Enter your password: ");

        User user = findUser(username, password, users);
        if (user != null) {
            ui.displayMessage("Login successful. Welcome back, " + user.getUsername() + "!");


        } else {
            ui.displayMessage("Invalid username or password. Please try again.");
            login();
        }

    }

    private User findUser(String username, String password, ArrayList<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }


    public void loadMediaData() {
        tvShows = MediaApplication.readTvShowsFromFile();
        movies = MediaApplication.readMoviesFromFile();
    }
    public void logOut(){}

    void runStreamingService(){}

    public void moveToWatchList(){}
}


// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram

