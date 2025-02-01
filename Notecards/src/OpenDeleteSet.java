import javax.swing.*;
import java.awt.*;

public class OpenDeleteSet extends JFrame {
    public OpenDeleteSet(){
        super();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        JPanel internalPanel = new JPanel();
        internalPanel.setLayout(new BorderLayout());
        content.add(internalPanel, BorderLayout.CENTER);
        internalPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY,10,true));

        //JPanel northPanel = new JPanel();
        internalPanel.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new BorderLayout());


        //settings
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


        add(northPanel, BorderLayout.NORTH);

        JPanel selectPanel = new JPanel();
        JLabel selectLabel = new JLabel("Select a Set to Open");

        selectPanel.add(selectLabel, BorderLayout.CENTER);
        internalPanel.add(selectPanel, BorderLayout.NORTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setVisible(true);
    }
}