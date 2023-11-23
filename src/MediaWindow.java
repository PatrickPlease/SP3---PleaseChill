import java.util.Scanner;

public class MediaWindow {
    private static final TextUI ui = new TextUI();
    private final Scanner scanner;

    public MediaWindow() {

        scanner = new Scanner(System.in);
    }

    public void displayMenu() {

        ui.displayMessage("1. Play Media");
        ui.displayMessage("2. Pause Media");
        ui.displayMessage("3. Rewind Media");
        ui.displayMessage("4. Forward Media");
        ui.displayMessage("5. CC");
        ui.displayMessage("6. Exit");
        ui.displayMessage("Enter your choice: ");
        int choice = scanner.nextInt();

        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                playMedia();
                break;
            case 2:
                pauseMedia();
                break;
            case 3:
                rewindMedia();
                break;
            case 4:
                forwardMedia();
                break;
            case 5:
                episodeOverview();
                break;
            case 6:
                exitMedia();
                break;
            default:
                ui.displayMessage("Invalid choice. Please try again.");
                displayMenu();
        }
    }

    public void playMedia() {
        ui.displayMessage("Now playing.");
        displayMenu();
    }

    public void pauseMedia() {
        ui.displayMessage("Paused.");
        displayMenu();
    }

    public void rewindMedia() {
        ui.displayMessage("Rewinding x2.");
        displayMenu();
    }

    public void forwardMedia() {
        ui.displayMessage("Forwarding 2x.");
        displayMenu();
    }

    public void episodeOverview() {
        ui.displayMessage("List of episodes: ");
        displayMenu();
    }

    public void exitMedia() {
        ui.displayMessage("Exiting media player.");
        scanner.close();
    }

    public static void main(String[] args) {
        MediaWindow mediaWindow = new MediaWindow();
        mediaWindow.displayMenu();
    }
}
