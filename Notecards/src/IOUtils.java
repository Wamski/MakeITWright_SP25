import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class IOUtils {
    public static void saveNotecards(String setName) {

        String userHome = System.getProperty("user.home");
        Path saves = Paths.get(userHome, "Desktop/Notecards/" + setName + ".txt");
        //System.out.println(saves.toString());

        File save = new File(saves.toString());
        if (save.exists()) {

            try {

                //Scanner sc = new Scanner (save);
                //System.out.println(save);
                FileWriter fw = new FileWriter(save, false);

                String finalSave = "";
                //For loop
                for (int i = 0; i < Main.getNotecardList().size(); i++){
                    String s = Main.getNotecardList().get(i).getQuestion() + "," + Main.getNotecardList().get(i).getAnswer() + ";";
                    finalSave = finalSave.concat(s);
                }
                System.out.println(finalSave);
                fw.write(finalSave);
                fw.close();

            } catch (IOException e) {

            }
        } else {
            try {
                boolean fileCreated = save.createNewFile(); // Attempt to create the file
                if (fileCreated) {
                    //System.out.println("New file created at: " + save.getAbsolutePath());
                    // You can also initialize the file with some content here if needed.
                    try {

                        //Scanner sc = new Scanner (save);
                        //System.out.println(save);
                        FileWriter fw = new FileWriter(save, false);

                        String finalSave = "";
                        //For loop
                        for (int i = 0; i < Main.getNotecardList().size(); i++){
                            String s = Main.getNotecardList().get(i).getQuestion() + "," + Main.getNotecardList().get(i).getAnswer() + ";";
                            finalSave = finalSave.concat(s);
                        }
                        System.out.println(finalSave);
                        fw.write(finalSave);
                        fw.close();

                    } catch (IOException e) {

                    }
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle file creation errors
            }
        }



    }

    public static void readNotecards(String setName) {

        String userHome = System.getProperty("user.home");
        Path saves = Paths.get(userHome, "Desktop/Notecards/" + setName + ".txt");
        File save = new File(saves.toString());
        String unSeperated = "";
        if(save.exists()) {
            try {
                Scanner sc = new Scanner(save);
                if (sc.hasNextLine()) {
                    unSeperated = sc.nextLine();
                    System.out.println(unSeperated);
                }
                sc.close();
                parseAndSaveToList(unSeperated);
            } catch (FileNotFoundException e) {
                return;
            }
        }
    }

    private static void parseAndSaveToList(String s){
        String[] semiSep = s.split(";");
        for(int i=0; i<semiSep.length; i++){
            String[] tempFinal = semiSep[i].split(",");
            cardObj c = new cardObj(tempFinal[0], tempFinal[1]);
            Main.addToList(c);
        }
    }
}
