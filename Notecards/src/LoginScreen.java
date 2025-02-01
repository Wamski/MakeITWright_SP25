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
        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.setBackground(white);

            //Title Panel
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));

            JLabel titleLabel = new JLabel("Welcome!");
            titleLabel.setFont(new Font("Dialog", Font.PLAIN, 60));
            
            titlePanel.add(titleLabel);
            mainPanel.add(titlePanel);

            //Username Panel
            JPanel usernamePanel = new JPanel();
            usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 110));

            JLabel usernameTextLabel = new JLabel("Username:");
            usernameTextLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            JTextField usernameLabel = new JTextField("U");
            usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            usernamePanel.add(usernameTextLabel);

            usernamePanel.add(usernameLabel);

            mainPanel.add(usernamePanel);

            //Password Panel
            JPanel passwordPanel = new JPanel();
            passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            JTextField passwordTextLabel = new JTextField("P");
            passwordTextLabel.setFont(new Font("Dialog", Font.PLAIN, 30));

            passwordPanel.add(passwordLabel);
            passwordPanel.add(passwordTextLabel);

            mainPanel.add(passwordPanel);

            //Incorrect Panel
            JPanel incorrectPanel = new JPanel();
            incorrectPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 90));
            
            JLabel incorrectLabel = new JLabel("Incorrect Username or Password");
            incorrectLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
            incorrectLabel.setForeground(Color.RED);
            incorrectLabel.setVisible(false);
            
            incorrectPanel.add(incorrectLabel);
            mainPanel.add(incorrectPanel);

        content.add(mainPanel, BorderLayout.CENTER);
        
        //LoginButton
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());
        JPanel centeringPanel = new JPanel();
        centeringPanel.setBackground(white);
        centeringPanel.setLayout(new GridBagLayout());
        centeringPanel.setBorder(BorderFactory.createLineBorder(white,10,true));
        centeringPanel.add(southPanel);
        
        JButton LoginButton = new JButton("Login");
        LoginButton.setBackground(white);
        LoginButton.addActionListener(e -> {
            if(passwordTextLabel.getText().equals("hello")){
                new StarterFrame();
                this.dispose();
            }else{
                incorrectLabel.setVisible(true);
            }
        });




        southPanel.add(LoginButton);
        content.add(centeringPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocation(800,50);
        this.setVisible(true);
    }
}