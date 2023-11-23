import java.util.ArrayList;
import java.util.List;

    public class Category {
        private TextUI ui = new TextUI();

        public void searchByName(String name, List<TvShow> tvShows, List<Movies> movies) {
            boolean foundResults = false;

            ui.displayMessage("Search results in TV Shows:");
            for (TvShow tvShow : tvShows) {
                if (tvShow.getTitle().toLowerCase().contains(name.toLowerCase().trim())){
                    ui.displayMessage(tvShow.getTitle() + " - Release year: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
                    System.out.println();
                    foundResults = true;
                }
            }

            ui.displayMessage("Search results in Movies:");
            for (Movies movie : movies) {
                if (movie.getTitle().toLowerCase().contains(name.toLowerCase().trim())) {
                    ui.displayMessage(movie.getTitle() + " - Release year: " + movie.getReleaseYear());
                    System.out.println();
                    foundResults = true;
                }
            }

            if (!foundResults) {
                ui.displayMessage("No results found for '" + name + "'.");
            }
        }

        public void searchByGenre(String genre, List<TvShow> tvShows, List<Movies> movies) {
            ui.displayMessage("Search results in TV Shows by Genre:");
            for (TvShow tvShow : tvShows) {
                if (tvShow.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                    ui.displayMessage(tvShow.getTitle() + " - Release year: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
                }
            }

            ui.displayMessage("Search results in Movies by Genre:");
            for (Movies movie : movies) {
                if (movie.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                    ui.displayMessage(movie.getTitle() + " - Release year: " + movie.getReleaseYear());
                    System.out.println();
                }
            }
        }

        public void searchByYear(int year, List<TvShow> tvShows, List<Movies> movies) {
            ui.displayMessage("Search results in TV Shows by Year:");
            for (TvShow tvShow : tvShows) {
                if (tvShow.getStartYear() <= year && tvShow.getEndYear() >= year) {
                    ui.displayMessage(tvShow.getTitle() + " - Release year: " + tvShow.getStartYear() + "-" + tvShow.getEndYear());
                }
            }

            ui.displayMessage("Search results in Movies by Year:");
            for (Movies movie : movies) {
                if (movie.getReleaseYear() == year) {
                    ui.displayMessage(movie.getTitle() + " - Release year: " + movie.getReleaseYear());
                }
            }
        }
    }