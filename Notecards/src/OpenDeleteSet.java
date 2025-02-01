import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        String[] exampleFiles = {Main.getEXAMPLE_SET_PATH(), "Set2.txt", "Set3.txt"}; // TODO: Example file names. Read from user's files
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
            if (openOrDelete.equalsIgnoreCase("open")) {
                SettingsUtil.newSet((String) fileDropdown.getSelectedItem());
            } 
            else if (openOrDelete.equalsIgnoreCase("delete")) {
                // Get the relative path from the dropdown
                String relativePath = (String) fileDropdown.getSelectedItem();
                
                // Combine it with the current working directory to get the absolute path
                Path absolutePath = Paths.get(System.getProperty("user.dir")).resolve(relativePath).toAbsolutePath();
        
                try {
                    // Delete the file using the absolute path
                    Files.delete(absolutePath);
                    System.out.println("File deleted successfully.");
                } 
                catch (NoSuchFileException e1) {
                    System.out.println("No such file exists.");
                } 
                catch (DirectoryNotEmptyException e2) {
                    System.out.println("Directory is not empty.");
                } 
                catch (IOException e3) {
                    System.out.println("Error deleting the file.");
                }
            }
        });
        


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLocation(800, 50);
        this.setVisible(true);
    }
}
