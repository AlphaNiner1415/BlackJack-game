import java.awt.*;
import javax.swing.*;
public class JFrameTest extends JPanel{
    static GraphicsConfiguration gc;
    public void paint(Graphics g){
        g.drawLine(10,10,200,300);
    }
    public static void main(String[] args) {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        
        

        // JFrame of Blackjack
        JFrame frame = new JFrame("Blackjack Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel userMoney = new JLabel("Money Remaining: $" + player.getMoney());
        JLabel userHandTotal = new JLabel("Total: " + player.getTotal());
        userMoney.setBounds(0, 0, 180, 25);
        userHandTotal.setBounds(0, 40, 100, 25);
        panel.add(userHandTotal);
        panel.add(userMoney);
        frame.add(panel);
        frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel){
        panel.setLayout(null);
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Same process for password label and text field.
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        /*
         * This is similar to text field but it hides the user entered data and displays
         * dots instead to protect the password like we normally see on login screens.
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Creating login button
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
    }
}