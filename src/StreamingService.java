import java.util.ArrayList;

public class StreamingService {
    CreateAccount newAccount;
    Category newCategory;
    Watchlist list;
    FileIO io;
    private TextUI ui = new TextUI();
    static ArrayList<User> users;



    public void setup(){
        ui.displayMessage("Welcome to PleaseChill, your favorite streaming platform");

        ArrayList<String> data = io.readUserData("data/UserData.txt");
        if (ui.getInput("Type L to Login, Type C to Create account").equalsIgnoreCase("L")){
            login();
        } else {

        }




    }

    public void login(){

    }

    public Media searchByName(){
        return null;
    }

    public Media searchByCategory(){
        return null;
    }

    public Media searchByYear(){}

    public void logOut(){}

    void runStreamingService(){}

    public void moveToWatchList(){}
}


// TextUI skal laves om til metode (getInput og displaymessage)
// Alt fra start() skal sættes in Streaming service
// Struktur ud fra klasse diagram