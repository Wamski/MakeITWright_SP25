import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JTextField questionField = new JTextField();
        JTextField answerField = new JTextField();

        Object[] message = {
                "Question:", questionField,
                "Answer:", answerField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Notecard", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String question = questionField.getText().trim();
            String answer = answerField.getText().trim();

            if (!question.isEmpty() && !answer.isEmpty()) {
                Main.addToList(new cardObj(question, answer));
                // saveNotecards();
                JOptionPane.showMessageDialog(this, "Notecard Added!");
            } else {
                JOptionPane.showMessageDialog(this, "Both fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
