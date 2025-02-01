import javax.swing.*;
import java.awt.*;

public class StarterFrame extends JFrame {
    public StarterFrame(){
        super("Cards");
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // new EditSetScreen(content);

        content.repaint();
        content.revalidate();

    }

}
