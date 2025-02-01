import java.util.ArrayList;

public class Main {
    private static ArrayList<cardObj> notecardList = new ArrayList<>();
    // private static ArrayList<CredentialsObj> credentialsList = new ArrayList<>();
    private final String CREDENTIALS_PATH = "./credentials.json";
    
    public static void main(String[] args) {
        StarterFrame window = new StarterFrame();

        // TODO: List of card objs that is empty till it reads from a file
        // notecardList = IOUtils.loadNotecards(null);
        // credentialsList = IOUtils.loadCredentials(CREDENTIALS_PATH)

    }

    public static void addToList(cardObj c){
        notecardList.add(c);

        for(int i = 0; i <= notecardList.size()-1; i++){
            System.out.println("------------------------");
            System.out.println(notecardList.get(i).getQuestion());
            System.out.println(notecardList.get(i).getAnswer());
            System.out.println("------------------------");
        }

    }

    public static ArrayList<cardObj> getNotecardList() {
        return notecardList;
    }

}
