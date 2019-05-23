import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIRunner extends JFrame implements ActionListener{
    private static JTextField number;
    private static JButton numberOk;
    private static JButton hit;
    private static JButton stand;
    private static JLabel instruction;
    private static JLabel actionDone;
    public int betAmount;
    public String action ="";
    
    private enum Actions{
        ENTER, HIT, STAND
    }
    public GUIRunner(){
        number = new JTextField(4);
        numberOk = new JButton("Enter");
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        instruction = new JLabel("Please Enter your bet: ");
        actionDone = new JLabel("");
        Dimension size1 = instruction.getPreferredSize();
        Dimension size2 = number.getPreferredSize();
        System.out.println(size1.width);
        System.out.println(size2.width);
        FlowLayout experimentalLayout = new FlowLayout();
        setLayout(experimentalLayout);
        setSize(350,300);
        setTitle("Gameplay Interface");

        //numberOk.setActionCommand(Actions.ENTER.toString());
        numberOk.addActionListener(this);
        //hit.setActionCommand(Actions.HIT.toString());
        hit.addActionListener(this);
        //stand.setActionCommand(Actions.STAND.toString());
        stand.addActionListener(this);
        //instruction.setBounds(105,50,size1.width,size1.height);
        //number.setBounds(145,70,size2.width, size2.height);
        add(instruction);
        add(number);
        add(numberOk);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == numberOk){
            betAmount = Integer.parseInt(number.getText());
            getContentPane().removeAll();
            instruction.setText("Please Choose your action: ");
            add(instruction);
            add(hit);
            add(stand);
            revalidate();
            repaint();
        }
        if(e.getSource() == hit){
            actionDone.setText("Hitting!");
            add(actionDone);
            revalidate();
            repaint();
            action = "Hit";

        }
        if(e.getSource()== stand){
            actionDone.setText("Standing!");
            add(actionDone);
            revalidate();
            repaint();
            action = "Stand";
        }
    }
    public int getbetAmount(){
        return betAmount;
    }
        
}

