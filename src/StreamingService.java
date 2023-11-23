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
        mainpage();
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

    public void mainpage() {
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
                        mainpage();
                        break;
                    default:
                        ui.displayMessage("Invalid choice. Please try again.");
                        mainpage();
                        break;
                }
                break;
            case 2:
                moviepage();
                break;
            case 3:
                seriespage();
                break;
            case 4:
                ui.displayMessage("You are now leaving PleaseChill..");
                ui.displayMessage("============================================= \n");
                setup();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                mainpage();
                break;
        }
    }

    public void moviepage() {
        ui.displayMessage("============================================= \n");
        int moviepage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
        switch (moviepage) {
            case 1:
                MediaApplication.moviesPrinter();
                ui.displayMessage("============================================= \n" +
                        "Choose a movie:");
                int selectedMovieNumber = Integer.parseInt(ui.getInput("Enter the number of the movie you want to watch: "));
                Movies selectedMovie = findMovieByNumber(selectedMovieNumber, movies);
                if (selectedMovie != null) {
                    ui.displayMessage("You have selected: " + selectedMovie.getTitle());
                }
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
                mainpage();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }

    public void seriespage() {
        ui.displayMessage("============================================= \n");
        int seriespage = Integer.parseInt(ui.getInput(" 1. Popular \n 2. Trending \n 3. Genres  \n 4. Recently watched \n 5. Watchlist \n 6. Return "));
        switch (seriespage) {
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
                mainpage();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                break;
        }
    }


    public Media searchByName() {
        return null;
    }

    public ArrayList<Media> searchByCategory() {
        return null;
    }

    public ArrayList<Media> searchByYear() {
        return null;
    }

    public void loadMediaData() {
        tvShows = MediaApplication.readTvShowsFromFile();
        movies = MediaApplication.readMoviesFromFile();
    }

    void runStreamingService() {
    }

    public void addToWatchlist(User user) {
        String newWatchlistItem = ui.getInput("Enter the title of the movie to add to your watchlist:");
        FileIO.addToWatchlist(user, newWatchlistItem);
        ui.displayMessage("Movie are now added to your watchlist!");
    }
    private void printMoviesWithNumbers(List<Movies> movies) {
        int movieNumber = 1;
        for (Movies movie : movies) {
            ui.displayMessage(movieNumber + ". " + movie.getTitle() + " - y: " + movie.getReleaseYear());
            movieNumber++;
        }
    }

    private Movies findMovieByNumber(int selectedMovieNumber, List<Movies> movies) {
        if (selectedMovieNumber > 0 && selectedMovieNumber <= movies.size()) {
            return movies.get(selectedMovieNumber - 1);
        } else {
            return null;
        }

    }
}
// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram

