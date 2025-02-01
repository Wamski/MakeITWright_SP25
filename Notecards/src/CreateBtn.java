import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateBtn extends JButton implements ActionListener  {

    CreateBtn(){
        super("Create");
        this.setSize(300,300);
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get input from user for question and anser
        // create a new cardObj with those variables and
        // append to the arraylist
        String question = JOptionPane.showInputDialog(null, "Enter the question:");
        String answer = JOptionPane.showInputDialog(null, "Enter the answer:");

        cardObj cO = new cardObj(question, answer);
        Main.addToList(cO);
    }
}
