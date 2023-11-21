import java.util.ArrayList;

public class StreamingService {
    CreateAccount newAccount;
    Category newCategory;
    Watchlist list;
    FileIO io;
    private TextUI ui = new TextUI();
    static ArrayList<User> users;


    public void setup(){
        ui.displayMessage("Welcome. Please create a username and password");
        CreateAccount.createUser();
    }

    public void login(){}

    public Media searchByName(){
        return null;
    }

    public Media searchByCategory(){
        return null;
    }
    public Media searchByYear(){return null;}

    public void logOut(){}

    void runStreamingService(){}

    public void moveToWatchList(){}
}


// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram