import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateBtn extends JButton implements ActionListener  {
    public ArrayList<cardObj> list = new ArrayList<>();
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


    }
}
