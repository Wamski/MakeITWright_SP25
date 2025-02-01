//focus on confirmation does not work??? (Small error somwehere)
//TODO array credentials gets reset after screen change


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;

public class RegisterScreen extends JFrame implements FocusListener {

    public static ArrayList<CredentialsObj> credentials = new ArrayList<CredentialsObj>();
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField confirmationTextField;

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
        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.setBackground(white);

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 45));

            JLabel titleLabel = new JLabel("Sign Up!");
            titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
            
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            //Username Panel
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

            JLabel usernameLabel = new JLabel("Username:");
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            usernameTextField = new JTextField("Username");
            usernameTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            usernameTextField.setPreferredSize(new Dimension(153,37));
            usernameTextField.setForeground(Color.GRAY);
            usernameTextField.addFocusListener(this);


            usernamePanel.add(usernameLabel);
            usernamePanel.add(usernameTextField);
            mainPanel.add(usernamePanel);

            //Password Panel
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            passwordTextField = new JTextField("Password");
            passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            passwordTextField.setPreferredSize(new Dimension(155,35));
            passwordTextField.setForeground(Color.GRAY);
            passwordTextField.addFocusListener(this);

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordTextField);

            mainPanel.add(passwordPanel);

            //Confirmation Panel
            JPanel confirmationPanel = new JPanel();
            confirmationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            JLabel confirmationLabel = new JLabel("Confirmation:");
            confirmationLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            confirmationTextField = new JTextField("Password");
            confirmationTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            confirmationTextField.setPreferredSize(new Dimension(155,35));
            confirmationTextField.setForeground(Color.GRAY);
            confirmationTextField.addFocusListener(this);

            confirmationPanel.add(confirmationLabel);
            confirmationPanel.add(confirmationTextField);

            mainPanel.add(confirmationPanel);

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
                //if confirmation is blank
                }else if(confirmationTextField.getText().equals("")){
                    incorrectLabel.setText("Please enter a confirmation");
                    incorrectLabel.setVisible(true);
                //if confirmation does not match password
                }else if(!(confirmationTextField.getText().equals(passwordTextField.getText()))){
                    incorrectLabel.setText("Please enter the same password in the password box as the confirmation box");
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

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == passwordTextField) {
            if (passwordTextField.getText().equals("Password")) {
                passwordTextField.setText(""); // Clear placeholder text
                passwordTextField.setForeground(Color.BLACK); // Change text color to black
            }
        } else if (e.getSource() == usernameTextField) {
            if (usernameTextField.getText().equals("Username")) {
                usernameTextField.setText("");
                usernameTextField.setForeground(Color.BLACK);
            }
        } else if (e.getSource() == confirmationTextField) {
            if (confirmationTextField.getText().equals("Confirmation")) {
                confirmationTextField.setText("");
                confirmationTextField.setForeground(Color.BLACK);
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == passwordTextField) {
            if (passwordTextField.getText().isEmpty()) {
                passwordTextField.setText("Password"); // Reset placeholder text if the field is empty
                passwordTextField.setForeground(Color.GRAY); // Change text color back to gray
            }
        } else if (e.getSource() == usernameTextField) {
            if (usernameTextField.getText().isEmpty()) {
                usernameTextField.setText("Username");
                usernameTextField.setForeground(Color.GRAY);
            }
        } else if (e.getSource() == confirmationTextField) {
            if (confirmationTextField.getText().isEmpty()) {
                confirmationTextField.setText("Confirmation");
                confirmationTextField.setForeground(Color.GRAY);
            }
        }
    }
}