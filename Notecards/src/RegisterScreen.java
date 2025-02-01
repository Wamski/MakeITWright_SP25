//TODO array credentials gets reset after screen change


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

public class RegisterScreen extends JFrame {

    public static ArrayList<CredentialsObj> credentials = new ArrayList<CredentialsObj>();

    public RegisterScreen() {
        super();
        ArrayList<CredentialsObj> credentials = new ArrayList<CredentialsObj>();

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        //Colors
        Color white = new Color(244, 238, 255);
        Color peach = new Color(233,156,134);

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.setBackground(white);

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));

            JLabel titleLabel = new JLabel("Sign Up!");
            titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
            
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            //Username Panel
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 110));

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            JTextField usernameTextField = new JTextField("Username");
            usernameTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            usernameTextField.setPreferredSize(new Dimension(153,37));


            usernamePanel.add(usernameLabel);
            usernamePanel.add(usernameTextField);
            mainPanel.add(usernamePanel);

            //Password Panel
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            JTextField passwordTextField = new JTextField("Password");
            passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            passwordTextField.setPreferredSize(new Dimension(155,35));

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordTextField);

            mainPanel.add(passwordPanel);

            //Incorrect Panel
            JPanel incorrectPanel = new JPanel();
            incorrectPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));
            
            JLabel incorrectLabel = new JLabel("Please enter a username and password");
            incorrectLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
            incorrectLabel.setForeground(Color.RED);
            incorrectLabel.setVisible(false);
            
            incorrectPanel.add(incorrectLabel);
            mainPanel.add(incorrectPanel);

        content.add(mainPanel, BorderLayout.CENTER);
        
        //ButtonsPanel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(white);
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createLineBorder(white,10,true));
        
            //RegisterButton

            JButton LoginButton = new JButton("Register");
            LoginButton.setBackground(white);
            LoginButton.addActionListener(e -> {
                boolean taken = false;
                //if username is blank
                if(usernameTextField.getText().equals("")){
                    incorrectLabel.setText("Please enter a username");
                    incorrectLabel.setVisible(true);
                //if password is blank
                }else if(passwordTextField.getText().equals("")){
                    incorrectLabel.setText("Please enter a password");
                    incorrectLabel.setVisible(true);
                //if username is less than 8 characters
                }else if(usernameTextField.getText().length() < 8){
                        incorrectLabel.setText("Username must be at least 8 characters long");
                        incorrectLabel.setVisible(true);
                //if password is less than 8 characters
                }else if(passwordTextField.getText().length() < 8){
                        incorrectLabel.setText("Password must be at least 8 characters long");
                        incorrectLabel.setVisible(true);
                }else{
                    //if username matches a taken username
                    for(CredentialsObj credentialsObj : credentials) {
                        if (usernameTextField.getText().equals(credentialsObj.getUsername())){
                            incorrectLabel.setText("Username already taken");
                            incorrectLabel.setVisible(true);
                            taken = true;
                        }
                    //if password matches a taken password
                    }for(CredentialsObj credentialsObj : credentials){
                        if(passwordTextField.getText().equals(credentialsObj.getPassword())){
                            incorrectLabel.setText("Password already taken");
                            incorrectLabel.setVisible(true);
                            taken = true;
                        }
                    }
                    //otherwise make credential
                    if(taken == false){
                        CredentialsObj login = new CredentialsObj(usernameTextField.getText(), passwordTextField.getText());
                        credentials.add(login);
                        incorrectLabel.setVisible(false);
                        //new LoginScreen();
                       // this.dispose();
                    }
                }
            });

            //BackButton
            JButton BackButton = new JButton("Back");
            BackButton.setBackground(white);
            BackButton.addActionListener(e -> {
                new LoginScreen();
                this.dispose();
            });

        buttonsPanel.add(BackButton);
        buttonsPanel.add(LoginButton);
        content.add(buttonsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setVisible(true);
    }

    public static ArrayList<CredentialsObj> getCredentials() {
        return credentials;
    }
}