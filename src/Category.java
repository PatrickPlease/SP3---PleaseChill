import java.util.ArrayList;
import java.util.List;

public class Category {
    private TextUI ui = new TextUI();

    public void searchByName(String name, List<TvShow> tvShows, List<Movies> movies) {
        boolean foundResults = false;

        ui.displayMessage("Search results in TV Shows:");
        for (int i = 0; i < tvShows.size(); i++) {
            if (tvShows.get(i).getTitle().toLowerCase().contains(name.toLowerCase().trim())) {
                ui.displayMessage((i + 1) + ". " + tvShows.get(i).getTitle() + " - Release year: " + tvShows.get(i).getStartYear() + "-" + tvShows.get(i).getEndYear());
                foundResults = true;
            }
        }

        ui.displayMessage("Search results in Movies:");
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getTitle().toLowerCase().contains(name.toLowerCase().trim())) {
                ui.displayMessage((i + 1) + ". " + movies.get(i).getTitle() + " - Release year: " + movies.get(i).getReleaseYear());

                foundResults = true;
            }
        }

        if (!foundResults) {
            ui.displayMessage("No results found for '" + name + "'.");
        }

    }


    public void searchByGenre(String genre, List<TvShow> tvShows, List<Movies> movies) {
        boolean foundResults = false;

        ui.displayMessage("Search results in TV Shows by Genre:");
        for (TvShow tvShow : tvShows) {
            if (tvShow.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                ui.displayMessage(tvShow.getTitle() + " - Release year: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
                System.out.println();
                foundResults = true;
            }
        }

        ui.displayMessage("Search results in Movies by Genre:");

        for (Movies movie : movies) {
            if (movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                ui.displayMessage(movie.getTitle() + " - Release year: " + movie.getReleaseYear());
                System.out.println();
                foundResults = true;
            }
        }
        if (!foundResults) {
            ui.displayMessage("No results found for '" + genre + "'.");
        }
    }

    public void searchByYear(int year, List<TvShow> tvShows, List<Movies> movies) {
        boolean foundResults = false;
        ui.displayMessage("Search results in TV Shows by Year:");
        for (TvShow tvShow : tvShows) {
            if (tvShow.getStartYear() <= year && tvShow.getEndYear() >= year) {
                ui.displayMessage(tvShow.getTitle() + " - Release year: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
                foundResults = true;
            }
        }

        ui.displayMessage("Search results in Movies by Year:");
        for (Movies movie : movies) {
            if (movie.getReleaseYear() == year) {
                ui.displayMessage(movie.getTitle() + " - Release year: " + movie.getReleaseYear());
                foundResults = true;
            }
        }
        if (!foundResults) {
            ui.displayMessage("No results found for '" + year + "'.");
        }
    }
}