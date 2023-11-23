import java.util.ArrayList;
import java.util.List;



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
        Mainpage();
    }

    public void login() {
        String username = ui.getInput("Enter your username: ");
        String password = ui.getInput("Enter your password: ");

        User user = io.readUserData(username);

        if (user != null && user.getPassword().equals(password)) {
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

    public void Mainpage(){
        int mainpage = Integer.parseInt(ui.getInput(" 1. Search \n 2. Movies \n 3. Series \n 4. Log out"));
        switch (mainpage) {
            case 1:
                searchByName();
                break;
            case 2:
                Moviepage();
                break;
            case 3:
                Seriespage();
                break;
            case 4:
                ui.displayMessage("You are now leaving PleaseChill..");
                ui.displayMessage("============================================= \n");
                setup();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }

    public void Moviepage(){
        ui.displayMessage("============================================= \n");
        int moviepage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
        switch(moviepage) {
            case 1:
                MediaApplication.moviesPrinter();
                break;
            case 2:
                ui.displayMessage("============================================= \n");
                break;
            case 3:
                ui.displayMessage("============================================= \n");
                break;
            case 4:
                ui.displayMessage("============================================= \n");
                break;
            case 5:
                ui.displayMessage("============================================= \n");
                //addToWatchlist();
                break;
            case 6:
                ui.displayMessage("============================================= \n");
                Mainpage();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }

    public void Seriespage(){
        ui.displayMessage("============================================= \n");
        int seriespage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
        switch(seriespage) {
            case 1:
                ui.displayMessage("============================================= \n");
                MediaApplication.tvShowPrinter();
                break;
            case 2:
                ui.displayMessage("============================================= \n");
                break;
            case 3:
                ui.displayMessage("============================================= \n");
                break;
            case 4:
                ui.displayMessage("============================================= \n");
                break;
            case 5:
                ui.displayMessage("============================================= \n");
                break;
            case 6:
                ui.displayMessage("============================================= \n");
                Mainpage();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }


    public Media searchByName(){
        return null;
    }

    public ArrayList<Media> searchByCategory(){
        return null;
    }

    public ArrayList<Media> searchByYear() {
        return null;
    }

    public void loadMediaData() {
      /*  tvShows = readTvShowsFromFile();
        movies = readMoviesFromFile();*/
    }

    void runStreamingService(){}

    public void addToWatchlist(User user) {
        String newWatchlistItem = ui.getInput("Enter the title of the movie to add to your watchlist:");
        FileIO.addToWatchlist(user, newWatchlistItem);
        ui.displayMessage("Movie are now added to your watchlist!");
    }

}


// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram

