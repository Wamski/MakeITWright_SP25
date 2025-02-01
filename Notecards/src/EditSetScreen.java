import javax.swing.*;
import java.awt.*;

public class EditSetScreen extends JFrame {
    private int currentIndex = 0;

    public EditSetScreen(String setTitle) {
        super();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        JPanel editScreenPanel = new JPanel();
        editScreenPanel.setLayout(new BorderLayout());
        content.add(editScreenPanel, BorderLayout.CENTER);

        // East Panel
        JButton eastButton = new JButton(">");
        eastButton.setFont(new Font("Arial", Font.PLAIN, 80));
        eastButton.setPreferredSize(new Dimension(100, 500));
        eastButton.setBackground(Color.WHITE);
        eastButton.setFocusPainted(false);
        eastButton.setBorder(null);
        eastButton.addActionListener(e -> { updateCardOrder("addition"); editScreenPanel.repaint(); editScreenPanel.revalidate(); });
        editScreenPanel.add(eastButton, BorderLayout.EAST);

        // West Panel
        JButton westButton = new JButton("<");
        westButton.setFont(new Font("Arial", Font.PLAIN, 80));
        westButton.setPreferredSize(new Dimension(100, 500));
        westButton.setBackground(Color.WHITE);
        westButton.setFocusPainted(false);
        westButton.setBorder(null);
        westButton.addActionListener(e -> { updateCardOrder("subtraction"); editScreenPanel.repaint(); editScreenPanel.revalidate(); });
        editScreenPanel.add(westButton, BorderLayout.WEST);

        // North panel
        JPanel northPanel = new JPanel(new BorderLayout());
        editScreenPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.add(new SettingsUtil(this), BorderLayout.WEST);

        JLabel titleLabel = new JLabel(setTitle, SwingConstants.CENTER);
        titleLabel.setBackground(Color.WHITE);
        titleLabel.setOpaque(true);
        northPanel.add(titleLabel, BorderLayout.CENTER);

        // Delete if necessary. Can/should be replaced by "Quiz Me" button in the future
        JLabel otherLabel = new JLabel("                   ", SwingConstants.CENTER);
        otherLabel.setBackground(Color.WHITE);
        otherLabel.setOpaque(true); // <-- This makes the background color visible
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
        JPanel centerPanel = new JPanel(new GridBagLayout()); // Use GridBagLayout for centering
        editScreenPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.WHITE);
        
        // Label showing card number out of total cards
        JLabel cardLabel = new JLabel("Card " + (currentIndex + 1) + " of " + Main.getNotecardList().size(), SwingConstants.CENTER);
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        cardLabel.setBackground(Color.WHITE);
        cardLabel.setOpaque(true);
        cardLabel.setPreferredSize(new Dimension(200, 40));
        // cardLabel.setMargin(new Insets(10, 10, 10, 10)); // Set margins
        centerPanel.add(cardLabel, new GridBagConstraints());
        
        // Text Area for question/answer with wrapping and centering
        JTextArea cardTextArea = new JTextArea();
        cardTextArea.setWrapStyleWord(true);
        cardTextArea.setLineWrap(true);
        cardTextArea.setFont(new Font("Arial", Font.PLAIN, 20));
        cardTextArea.setEditable(false); 
        cardTextArea.setBackground(Color.WHITE);
        cardTextArea.setPreferredSize(new Dimension(400, 200));
        cardTextArea.setMargin(new Insets(10, 20, 10, 20));
        cardTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Creates a black border with thickness of 2        
        cardTextArea.setCaretPosition(0);
        cardTextArea.setAlignmentX(Component.CENTER_ALIGNMENT); // Horizontally center
        centerPanel.add(cardTextArea, new GridBagConstraints());
        
        try {
            cardTextArea.setText(Main.getNotecardList().get(currentIndex).getQuestion());
        } 
        catch (IndexOutOfBoundsException ioobe) {
            cardTextArea.setText("Error: Could not retrieve question");
        }
        
        // Toggle button for Question/Answer
        JButton toggleButton = new JButton("Show Answer");
        toggleButton.setFont(new Font("Arial", Font.PLAIN, 20));
        toggleButton.setBackground(Color.WHITE);
        toggleButton.setFocusPainted(false);
        toggleButton.setPreferredSize(new Dimension(200, 50));
        toggleButton.setMargin(new Insets(10, 20, 10, 20));

        toggleButton.addActionListener(e -> {
            if (cardTextArea.getText().equals(Main.getNotecardList().get(currentIndex).getQuestion())) {
                cardTextArea.setText(Main.getNotecardList().get(currentIndex).getAnswer()); 
                toggleButton.setText("Show Question");
            } 
            else {
                cardTextArea.setText(Main.getNotecardList().get(currentIndex).getQuestion()); 
                toggleButton.setText("Show Answer");
            }
        });
        centerPanel.add(toggleButton, new GridBagConstraints());

        // Centering the components using GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Set padding around components
        gbc.anchor = GridBagConstraints.CENTER;
        centerPanel.add(cardLabel, gbc);

        gbc.gridy = 1; // Move to next row
        centerPanel.add(cardTextArea, gbc);

        gbc.gridy = 2; // Move to next row
        centerPanel.add(toggleButton, gbc);

        // Revalidate and repaint to ensure layout is updated
        centerPanel.revalidate();
        centerPanel.repaint();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocation(800, 50);
        this.setVisible(true);

    }

    private void updateCardOrder(String operation) {
        if (Main.getNotecardList().isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no notecards in the list!");
        }
        else if (Main.getNotecardList().size() == currentIndex) { // FIXME: what is this doing?
            JOptionPane.showMessageDialog(null, "There are no more notecards to show!");
        }
        else {
            switch (operation) {
                case "subtraction": currentIndex--; System.out.println("sub"); break;
                case "addition": currentIndex++; System.out.println("add"); break;
                default: throw new IllegalStateException("You coded this wrong dingus!!!");
            }
        }
    }

}