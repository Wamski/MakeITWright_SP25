import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SettingsUtil extends JMenuBar {
    public SettingsUtil(JFrame currentFrame) {
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem newSet = new JMenuItem("New Set");
        newSet.addActionListener(e -> { currentFrame.dispose(); newSet(); });
        JMenuItem openSet = new JMenuItem("Open Set");
        openSet.addActionListener(e -> { openSet(); currentFrame.dispose(); });
        JMenuItem deleteSet = new JMenuItem("Delete Set");
        deleteSet.addActionListener(e -> { deleteSet(); currentFrame.dispose(); });
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(e -> { logout(); currentFrame.dispose(); });

        settingsMenu.add(newSet);
        settingsMenu.add(openSet);
        settingsMenu.add(deleteSet);
        settingsMenu.addSeparator();
        settingsMenu.add(logout);

        this.add(settingsMenu);
        this.setBackground(Color.WHITE);
    }

    public static void newSet() {
        JTextField pathField = new JTextField();
        Object[] message = { "File Name:", pathField };

        int option = JOptionPane.showConfirmDialog(null, message, "Enter Set Title", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String path = pathField.getText().trim();

            if (path.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Path field must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                new EditSetScreen(path);
            }
        }
    }

    public static void newSet(String path) {
        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Path field must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            new EditSetScreen(path);
        }
    }

    public static void openSet() {
        new OpenDeleteSet("Open");
    }

    public static void deleteSet() {
        new OpenDeleteSet("Delete");
    }

    public static void logout() {
        new LoginScreen();
    }
}
