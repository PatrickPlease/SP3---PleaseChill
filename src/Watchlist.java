import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private static TextUI ui = new TextUI();
    private List<Movies> watchlist;
    private List<Movies> watchedMovies;

    public Watchlist() {
        watchlist = new ArrayList<>();
        watchedMovies = new ArrayList<>();
    }

    public void addMedia(Movies movie) {
        watchlist.add(movie);
        ui.displayMessage("You have added a movie to your watchlist: " + movie.getTitle());
    }

    public void displayWatched() {
        if (watchedMovies.isEmpty()) {
            ui.displayMessage("You haven't watched any movies yet.");
        } else {
            ui.displayMessage("Movies you have already watched:");
            for (Movies movie : watchedMovies) {
                ui.displayMessage(movie.getTitle() + " (" + movie.getReleaseYear() + ")");
            }
        }
    }

    public void removeMedia(Movies movie) {
        if (watchlist.remove(movie)) {
            ui.displayMessage("You have removed this movie from your watchlist: " + movie.getTitle());
        } else {
            ui.displayMessage("The movie is not in your watchlist.");
        }
    }

    public void markAsWatched(Movies movie) {
        if (watchlist.contains(movie)) {
            watchlist.remove(movie);
            watchedMovies.add(movie);
            ui.displayMessage("You have marked this movie as watched: " + movie.getTitle());
        } else {
            ui.displayMessage("The movie is not in your watchlist.");
        }
    }

    public static void main(String[] args) {
        Watchlist myWatchlist = new Watchlist();

        addMoviesFromFile(myWatchlist);

        myWatchlist.displayWatched();
    }

    private static void addMoviesFromFile(Watchlist watchlist) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/100bedstefilm.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String title = data[0].trim();
                int releaseYear = Integer.parseInt(data[1].trim());
                float rating = Float.parseFloat(data[3].replace(",", ".").trim());
                String genre = data[2].trim();

                Movies movie = new Movies(title, releaseYear, rating, genre);
                watchlist.addMedia(movie);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
