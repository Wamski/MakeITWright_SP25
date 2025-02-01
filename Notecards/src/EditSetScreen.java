import javax.swing.*;
import java.awt.*;

public class EditSetScreen {
    private int currentIndex = 0;   

    public EditSetScreen(JPanel content){

        System.out.println(Main.getNotecardList().size());

        JPanel editScreenPanel = new JPanel();
        editScreenPanel.setLayout(new BorderLayout());
        content.add(editScreenPanel, BorderLayout.CENTER);

        // East Panel
        JButton eastButton = new JButton(">");
        eastButton.setFont(new Font("Arial", Font.PLAIN, 80));
        eastButton.setPreferredSize(new Dimension(100, 500));
        eastButton.setBackground(Color.WHITE);
        eastButton.setFocusPainted(false);
        eastButton.addActionListener(e -> { updateCardOrder("addition"); });
        editScreenPanel.add(eastButton, BorderLayout.EAST);
        
        // West Panel 
        JButton westButton = new JButton("<");
        westButton.setFont(new Font("Arial", Font.PLAIN, 80));
        westButton.setPreferredSize(new Dimension(100, 500));
        westButton.setBackground(Color.WHITE);
        westButton.setFocusPainted(false);
        westButton.addActionListener(e -> { updateCardOrder("subtraction"); });
        editScreenPanel.add(westButton, BorderLayout.WEST);

        // North panel
        JPanel northPanel = new JPanel(new BorderLayout());
        editScreenPanel.add(northPanel, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem newSet = new JMenuItem("New Set");
        newSet.addActionListener(e -> {System.out.println("newSet");}); // FIXME
        JMenuItem openSet = new JMenuItem("Open Set");
        openSet.addActionListener(e -> {System.out.println("openSet");}); // FIXME
        JMenuItem deleteSet = new JMenuItem("Delete Set");
        deleteSet.addActionListener(e -> {System.out.println("deleteSet");}); // FIXME
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(e -> {System.out.println("logout");}); // FIXME

        settingsMenu.add(newSet);
        settingsMenu.add(openSet);
        settingsMenu.add(deleteSet);
        settingsMenu.addSeparator(); 
        settingsMenu.add(logout);

        menuBar.add(settingsMenu);
        menuBar.setBackground(Color.WHITE);
        northPanel.add(menuBar, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("Set Title", SwingConstants.CENTER);
        titleLabel.setBackground(Color.BLUE);
        northPanel.add(titleLabel, BorderLayout.CENTER);

        // Delete if necessary. Can/should be replaced by "Quiz Me" button in the future 
        JLabel otherLabel = new JLabel("                   ", SwingConstants.CENTER);
        otherLabel.setBackground(Color.BLUE);
        northPanel.add(otherLabel, BorderLayout.EAST);

        // South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        editScreenPanel.add(southPanel, BorderLayout.SOUTH);

        JButton deleteNotecardButton = new JButton("Delete");
        deleteNotecardButton.setFont(new Font("Arial", Font.PLAIN, 20));
        deleteNotecardButton.setBackground(Color.WHITE);
        deleteNotecardButton.setFocusPainted(false);
        deleteNotecardButton.setPreferredSize(new Dimension(100, 50));
        southPanel.add(deleteNotecardButton, BorderLayout.WEST);
        
        deleteNotecardButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Would you like to delete this notecard?", "Delete Notecard", JOptionPane.YES_NO_OPTION);
            if (option == 0) { 
                if (Main.getNotecardList().size() > 0) {
                    Main.getNotecardList().remove(Main.getNotecardList().get(currentIndex));
                    // TODO: updateExistingNotecardsInFile
                    JOptionPane.showMessageDialog(null, "Notecard Deleted Successfully!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "There aren't any notecards to delete!");
                }
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.setFont(new Font("Arial", Font.PLAIN, 20));
        editButton.setBackground(Color.WHITE);
        editButton.setFocusPainted(false);
        editButton.setPreferredSize(new Dimension(500, 50));
        southPanel.add(editButton, BorderLayout.CENTER);
        
        editButton.addActionListener(e -> {
            JTextField questionField = new JTextField();
            JTextField answerField = new JTextField();

            Object[] message = { "Question:", questionField, "Answer:", answerField };
            
            if (Main.getNotecardList().size() == 0) {
                JOptionPane.showMessageDialog(null, "There aren't any notecards to edit!");
            }
            else {
                int option = JOptionPane.showConfirmDialog(editButton, message, "Edit Notecard", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String question = questionField.getText().trim();
                    String answer = answerField.getText().trim();
    
                    if (question.isEmpty() || answer.isEmpty()) {
                        JOptionPane.showMessageDialog(editButton, "Both fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    else {
                        Main.getNotecardList().get(currentIndex).setQuestion(question);
                        Main.getNotecardList().get(currentIndex).setAnswer(answer);
                        // TODO: updateExistingNotecardsInFile
                        JOptionPane.showMessageDialog(editButton, "Notecard Edited Successfully!");
                    }
                }
            }
        });
        
        JButton createNotecardButton = new JButton("Create");
        createNotecardButton.setFont(new Font("Arial", Font.PLAIN, 20));
        createNotecardButton.setBackground(Color.WHITE);
        createNotecardButton.setFocusPainted(false);
        createNotecardButton.setPreferredSize(new Dimension(100, 50));
        southPanel.add(createNotecardButton, BorderLayout.EAST);

        createNotecardButton.addActionListener(e -> {
            JTextField questionField = new JTextField();
            JTextField answerField = new JTextField();

            Object[] message = { "Question:", questionField, "Answer:", answerField };
            int option = JOptionPane.showConfirmDialog(null, message, "Add Notecard", JOptionPane.OK_CANCEL_OPTION);
            
            if (option == JOptionPane.OK_OPTION) {
                String question = questionField.getText().trim();
                String answer = answerField.getText().trim();

                if (!question.isEmpty() && !answer.isEmpty()) {
                    Main.addToList(new cardObj(question, answer));
                    // saveNotecards();
                    JOptionPane.showMessageDialog(null, "Notecard Added!");
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Both fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Center Panel 
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        editScreenPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.GREEN);

        // TODO: Add notecards to the screen 
        JPanel innerCenterPanel = new JPanel();
        innerCenterPanel.setLayout(new BorderLayout());
        editScreenPanel.add(innerCenterPanel, BorderLayout.CENTER);
        innerCenterPanel.setBackground(Color.GREEN);

        content.repaint();
        content.revalidate();

    }

    private void updateCardOrder(String operation) {
        if (!Main.getNotecardList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no notecards in the list!");
        }
        else if (Main.getNotecardList().size() == currentIndex) { // FIXME: what is this doing?
            JOptionPane.showMessageDialog(null, "There are no more notecards to show!");
        }
        else {
            switch (operation) {
                case "subtraction": currentIndex = (currentIndex - 1) % Main.getNotecardList().size(); break;
                case "addition": currentIndex = (currentIndex + 1) % Main.getNotecardList().size(); break;
                default: throw new IllegalStateException("You coded this wrong dingus!!!"); 
            }
            // displayNotecard();
        }
    }

}