import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        super();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        //Colors
        Color white = new Color(244, 238, 255);
        Color peach = new Color(233,156,134);

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));
        mainPanel.setBackground(white);

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 130));

            JLabel titleLabel = new JLabel("Welcome!");
            titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
            
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            //Username Panel
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 150));

            JTextField usernameLabel = new JTextField("Username");
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            usernamePanel.add(usernameLabel);
            mainPanel.add(usernamePanel);

            //Password Panel
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            JTextField passwordLabel = new JTextField("Password");
            passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            passwordPanel.add(passwordLabel);
            mainPanel.add(passwordPanel);

        content.add(mainPanel, BorderLayout.CENTER);

        //LoginButton
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());
        JPanel centeringPanel = new JPanel();
        centeringPanel.setBackground(white);
        centeringPanel.setLayout(new GridBagLayout());
        centeringPanel.setBorder(BorderFactory.createLineBorder(white,10,true));
        centeringPanel.add(southPanel);
        
        JButton startButton = new JButton("Login");
        startButton.setBackground(white);
        southPanel.add(startButton);

        content.add(centeringPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setVisible(true);
    }
}