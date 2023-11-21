public class Watchlist {
    private static TextUI ui = new TextUI();
    public void addMedia() {
        ui.displayMessage("You have add a movie to your list");
    }

    public void displayWatched(){
        ui.displayMessage("This movie you watch already");

    }


    public void removeMedia(){
        ui.displayMessage("You have remove this movie from your list");
    }
}
