public class Movie extends Media {
    public Movie(String title, int releaseYear, float rating, String genre) {
        super(title, releaseYear, rating, genre, false);
    }

    @Override
    public int getTimeWatched() {
        // Implementer logik for at få tidspunktet for filmen, hvis det er relevant
        return 0;
    }
}