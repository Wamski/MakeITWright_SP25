import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<cardObj> list = new ArrayList<>();
    public static void main(String[] args) {
        StarterFrame window = new StarterFrame();
        /* List of card objs that is empty till
        it reads from a file
         */


    }
    public static void addToList(cardObj c){
        list.add(c);

        /*
        for(int i = 0; i <= list.size()-1; i++){
            System.out.println("------------------------");
            System.out.println(list.get(i).question);
            System.out.println(list.get(i).answer);
        }
         */
    }

}
