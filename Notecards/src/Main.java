import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<CredentialsObj> credentialsList = new ArrayList<CredentialsObj>();
    private final String CREDENTIALS_PATH = "./credentials.json";
    
    private static ArrayList<cardObj> notecardList = new ArrayList<>();
    private static final String EXAMPLE_SET_PATH = "MySet.txt";


    public static void main(String[] args) {
        LoginScreen window = new LoginScreen();
        
        // IOUtils.readNotecards(EXAMPLE_SET_PATH);
        // EditSetScreen ess = new EditSetScreen(EXAMPLE_SET_PATH);
        
        // TODO: List of card objs that is empty till it reads from a file
        // notecardList = IOUtils.loadNotecards(null);
        // credentialsList = IOUtils.loadCredentials(CREDENTIALS_PATH)
    }


    public static void addCredentials(CredentialsObj a){
        credentialsList.add(a);
    }

    public static String getEXAMPLE_SET_PATH() {
        return EXAMPLE_SET_PATH;
    }

    public static void addToList(cardObj c){
        notecardList.add(c);


        
        for(int i = 0; i <= notecardList.size()-1; i++){
            System.out.println("------------------------");
            System.out.println(notecardList.get(i).getQuestion());
            System.out.println(notecardList.get(i).getAnswer());

        }

    }
    public static ArrayList<cardObj> getNotecardList() {
        return notecardList;
    }

}

