import javax.swing.*;
import java.awt.*;

public class OpenDeleteSet extends JFrame {
    public OpenDeleteSet(String openOrDelete){
        super();
        JPanel content = new JPanel(new BorderLayout());
        this.setContentPane(content);

        JPanel internalPanel = new JPanel(new BorderLayout());
        content.add(internalPanel, BorderLayout.CENTER);

        // North Panel
        JPanel northPanel = new JPanel(new BorderLayout());
        internalPanel.add(northPanel, BorderLayout.NORTH);
        northPanel.add(new SettingsUtil(this), BorderLayout.WEST);

        // Center Panel
        JPanel selectPanel = new JPanel(new GridBagLayout()); // Center components properly
        internalPanel.add(selectPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Adds spacing
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel selectLabel = new JLabel("Select a Set to " + openOrDelete);
        selectLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        selectPanel.add(selectLabel, gbc);

        // Drop-down Menu for File Selection
        gbc.gridy = 1; // Move to next row
        String[] exampleFiles = {"Set1.json", "Set2.json", "Set3.json"}; // TODO: Example file names. Read from user's files
        JComboBox<String> fileDropdown = new JComboBox<>(exampleFiles);
        fileDropdown.setFont(new Font("Arial", Font.PLAIN, 20));
        selectPanel.add(fileDropdown, gbc);

        // South Panel
        JPanel southPanel = new JPanel();
        internalPanel.add(southPanel, BorderLayout.SOUTH);

        JButton confirmButton = new JButton(openOrDelete);
        confirmButton.setPreferredSize(new Dimension(150, 50));
        confirmButton.setFont(new Font("Arial", Font.PLAIN, 25));
        southPanel.add(confirmButton);

        confirmButton.addActionListener(e -> {
            this.dispose();
            SettingsUtil.newSet((String) fileDropdown.getSelectedItem());
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocation(800, 50);
        this.setVisible(true);
    }
}
