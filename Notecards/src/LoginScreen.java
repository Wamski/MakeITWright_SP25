
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class LoginScreen extends JFrame implements FocusListener{

    private JTextField usernameTextField;
    private JTextField passwordTextField;

    public LoginScreen() {
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
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.setBackground(blue3);
        content.setBackground(blue3);
        mainPanel.setBorder(BorderFactory.createLineBorder(blue5,10,true));


        //Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 80));
        titlePanel.setBackground(blue3);

        JLabel titleLabel = new JLabel("Welcome!");
        titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));

        titlePanel.add(titleLabel);
        mainPanel.add(titlePanel);

        //Username Panel
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 110));
        usernamePanel.setBackground(blue3);


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
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        passwordPanel.setBackground(blue3);


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

        //Incorrect Panel
        JPanel incorrectPanel = new JPanel();
        incorrectPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));

        JLabel incorrectLabel = new JLabel("Incorrect Username or Password");
        incorrectLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
        incorrectLabel.setForeground(yellow);
        incorrectLabel.setVisible(false);
        incorrectPanel.setBackground(blue3);

        incorrectPanel.add(incorrectLabel);
        mainPanel.add(incorrectPanel);

        content.add(mainPanel, BorderLayout.CENTER);
        

        //LoginButton
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(blue3);
        buttonsPanel.setLayout(new GridBagLayout());

        buttonsPanel.setBorder(BorderFactory.createLineBorder(blue5,10,true));

        JButton LoginButton = new JButton("Login");
        LoginButton.addActionListener(e -> {
            for(CredentialsObj credentialsObj : RegisterScreen.getCredentials()) {
                if (usernameTextField.getText().equals(credentialsObj.getUsername()) && passwordTextField.getText().equals(credentialsObj.getPassword())){
                    new OpenDeleteSet("Open");
                    this.dispose();
                }
            }
            incorrectLabel.setVisible(true);
        });

        //RegisterButton
        JButton RegisterButton = new JButton("Register");
        RegisterButton.addActionListener(e -> {
            new RegisterScreen();
            this.dispose();
        });

        buttonsPanel.add(RegisterButton);
        buttonsPanel.add(LoginButton);
        content.add(buttonsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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
        }
    }
}