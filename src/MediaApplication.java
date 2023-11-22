import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MediaApplication {
    private static final TextUI ui = new TextUI();

    public static void main(String[] args) {
        List<TvShow> tvShows = readTvShowsFromFile();
        List<Movies> movies = readMoviesFromFile();

        ui.displayMessage("TV Shows:");
        for (TvShow tvShow : tvShows) {
            ui.displayMessage(tvShow.getTitle() + " - releaseyears: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
        }

        // Display Movies
        ui.displayMessage("\nMovies:");
        for (Movies movie : movies) {
            ui.displayMessage(movie.getTitle());
        }

        // Display Thriller Movies
        ui.displayMessage("\nThriller Movies:");
        for (Movies movie : movies) {
            if (movie.getGenre().equalsIgnoreCase("Thriller")) {
                ui.displayMessage(movie.getTitle());
            }
        }
    }

    private static List<TvShow> readTvShowsFromFile() {
        List<TvShow> tvShows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Data/100bedsteserie.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0].trim();
                String yearRange = parts[1].trim(); // assuming year range is the 2nd element
                String genre = parts[2].trim();

                float rating = Float.parseFloat(parts[3].replace(",", ".").trim());

                // Handling episodes
                String[] episodeData = parts[4].split(",");
                int totalSeasons = episodeData.length;

                // Extracting start and end years from the year range
                String[] years = yearRange.split("-");
                int startYear = Integer.parseInt(years[0].trim());

                // Check if there is an end year
                int endYear;
                if (years.length > 1) {
                    endYear = Integer.parseInt(years[1].trim());
                } else {
                    endYear = startYear;
                }

                TvShow tvShow = new TvShow(title, startYear, endYear, rating, genre, totalSeasons);

                for (int i = 0; i < totalSeasons; i++) {
                    String[] seasonData = episodeData[i].split("-");
                    int seasonNumber = Integer.parseInt(seasonData[0].trim());
                    int episodeCount = Integer.parseInt(seasonData[1].trim());

                    tvShow.addSeason(seasonNumber, episodeCount);
                }

                tvShows.add(tvShow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tvShows;
    }

    private static List<Movies> readMoviesFromFile() {
        List<Movies> movies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Data/100bedstefilm.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0].trim();
                int releaseYear = Integer.parseInt(parts[1].trim());
                String genre = parts[2].trim();
                float rating = Float.parseFloat(parts[3].replace(",", ".").trim());

                Movies movie = new Movies(title, releaseYear, rating, genre);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }
}