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

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        //Colors
        Color white = new Color(244, 238, 255);
        Color blue5 = new Color(0,59,92);
        Color blue4 = new Color(0,91,115);
        Color blue3 = new Color(0,122,142);
        Color blue2 = new Color(0,153,179);
        Color blue1 = new Color(224,247,250);
        Color yellow = new Color(241,212,161);

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,1));
        mainPanel.setBackground(blue3);
        content.setBackground(blue3);
        mainPanel.setBorder(BorderFactory.createLineBorder(blue5,10,true));

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 45));
            titlePanel.setBackground(blue3);

            JLabel titleLabel = new JLabel("Sign Up!");
            titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
            
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            //Username Panel
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 70));
            usernamePanel.setBackground(blue3);

            JLabel usernameLabel = new JLabel("Username: ");
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            usernameTextField = new JTextField("Username");
            usernameTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            usernameTextField.setPreferredSize(new Dimension(200,38));
            usernameTextField.setForeground(Color.GRAY);
            usernameTextField.addFocusListener(this);

            usernamePanel.add(usernameLabel);
            usernamePanel.add(usernameTextField);
            mainPanel.add(usernamePanel);

            //Password Panel
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 55));
            passwordPanel.setBackground(blue3);

            JLabel passwordLabel = new JLabel("Password: ");
            passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            passwordTextField = new JTextField("Password");
            passwordTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            passwordTextField.setPreferredSize(new Dimension(200,35));
            passwordTextField.setForeground(Color.GRAY);
            passwordTextField.addFocusListener(this);

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordTextField);
            mainPanel.add(passwordPanel);

            //Confirmation Panel
            JPanel confirmationPanel = new JPanel();
            confirmationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 45));
            confirmationPanel.setBackground(blue3);

            JLabel confirmationLabel = new JLabel("Confirmation: ");
            confirmationLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            confirmationTextField = new JTextField("Confirmation");
            confirmationTextField.setFont(new Font("Dialog", Font.PLAIN, 30));
            confirmationTextField.setPreferredSize(new Dimension(200,35));
            confirmationTextField.setForeground(Color.GRAY);
            confirmationTextField.addFocusListener(this);

            confirmationPanel.add(confirmationLabel);
            confirmationPanel.add(confirmationTextField);

            mainPanel.add(confirmationPanel);

            //Incorrect Panel
            JPanel incorrectPanel = new JPanel();
            incorrectPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
            incorrectPanel.setBackground(blue3);

            JLabel incorrectLabel = new JLabel("Please enter a username and password");
            incorrectLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
            incorrectLabel.setForeground(yellow);
            incorrectLabel.setVisible(false);
            
            incorrectPanel.add(incorrectLabel);
            mainPanel.add(incorrectPanel);

        content.add(mainPanel, BorderLayout.CENTER);
        
        //ButtonsPanel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(blue3);
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.setBorder(BorderFactory.createLineBorder(blue5,10,true));

        
            //RegisterButton
            JButton LoginButton = new JButton("Register");
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
                    incorrectLabel.setText("Passwords must match");
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
                    }
                    //otherwise make credential
                    if(taken == false){
                        CredentialsObj login = new CredentialsObj(usernameTextField.getText(), passwordTextField.getText());
                        credentials.add(login);

                        //credentials.addCredentials(login);

                        incorrectLabel.setVisible(false);
                        new LoginScreen();
                        this.dispose();
                    }
                }
            });

            //BackButton
            JButton BackButton = new JButton("Back");
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
        this.setLocationRelativeTo(null);
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
                usernameTextField.setText(""); // Clear placeholder text
                usernameTextField.setForeground(Color.BLACK);
            }
        } else if (e.getSource() == confirmationTextField) {
            if (confirmationTextField.getText().equals("Confirmation")) {
                confirmationTextField.setText(""); // Clear placeholder text
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
        }else{
            
        }
    }
}