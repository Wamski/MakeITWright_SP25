import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class SetEditor extends JFrame {
    public SetEditor(){
        super("Alligator Sandwich");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setVisible(true);
        //ex:

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        content.add(panel, BorderLayout.CENTER);
        

        JButton eastButton = new JButton("East Button");
        eastButton.setText(">"); //could've just initialized them with the ">" but wanted to try out setText for a refresher
        JButton westButton = new JButton("West Button");
        westButton.setText("<");

        //JPanel northPanel = new JPanel();
        panel.setLayout(new BorderLayout());


        JPanel northPanel = new JPanel(new BorderLayout());


         // Create the JComboBox
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JComboBox<String> comboBox = new JComboBox<>(items);


         // Add the JComboBox to the WEST of the North Panel
        northPanel.add(comboBox, BorderLayout.WEST);


         // Create a filler panel to take up remaining space in the north
        JPanel northEastPanel = new JPanel();
        northPanel.add(northEastPanel, BorderLayout.CENTER);


         // Add the North Panel to the NORTH of the JFrame
        add(northPanel, BorderLayout.NORTH);

        JTextField textfield = new JTextField("scream");
        
        northPanel.add(textfield, BorderLayout.CENTER);

        JButton editButton = new JButton("Edit");
        panel.add(editButton, BorderLayout.SOUTH);
        
        panel.add(eastButton, BorderLayout.EAST);
        panel.add(westButton, BorderLayout.WEST);

        content.repaint();
        content.revalidate();

    }

}