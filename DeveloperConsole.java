import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeveloperConsole {
    static int p1Life; //müssen static sein für UpdateWindow und UpdateWindow muss static sein für CharacterCreation
    static int p2Life;
    static boolean p1IsProtected;
    static boolean p2IsProtected;
    static int p1BurnCounter;
    static int p2BurnCounter;
    static JTextField JTextp1Life;
    static JTextField JTextp2Life;
    static JButton changeHealthP1;
    static JButton changeHealthP2;
    static JTextField JTextp1IsProtected;
    static JTextField JTextp2IsProtected;
    static JTextField JTextp1BurnCounter;
    static JTextField JTextp2BurnCounter;
    public DeveloperConsole () {
        JFrame devconsole =new JFrame("Developer Console");//creating instance of JFrame  
        
        JTextField JTextnameP1 = new JTextField(CharacterCreation.input1.getName());
        JTextField JTextnameP2 = new JTextField(CharacterCreation.input2.getName());
        int p1Life = CharacterCreation.input1.getLife();
        int p2Life = CharacterCreation.input2.getLife();
        boolean p1IsProtected = CharacterCreation.input1.getIsProtected();
        boolean p2IsProtected = CharacterCreation.input2.getIsProtected();
        int p1BurnCounter = CharacterCreation.input1.getBurnCounter();
        int p2BurnCounter = CharacterCreation.input2.getBurnCounter();
        
        JTextp1Life = new JTextField("Health: " + p1Life);
        JTextp2Life = new JTextField("Health: " + p2Life);
        JTextp1IsProtected = new JTextField("Is Protected: " + p1IsProtected);
        JTextp2IsProtected = new JTextField("Is Protected: " + p2IsProtected);
        changeHealthP1 = new JButton("Change health");
        changeHealthP2 = new JButton("Change health");
        JTextp1BurnCounter = new JTextField("BurnCounter for enemy: " + p1BurnCounter);
        JTextp2BurnCounter = new JTextField("BurnCounter for enemy: " + p2BurnCounter);
        
        
        JTextnameP1.setBounds(0,0, 400,30); //x axis, y axis, width, height  
        JTextnameP2.setBounds(0,200, 400,30);
        JTextnameP1.setEditable(false);
        JTextnameP2.setEditable(false);
        
        JTextp1Life.setBounds(30,30, 370,30); //x axis, y axis, width, height  
        JTextp2Life.setBounds(30,230, 370,30);
        JTextp1Life.setEditable(false);
        JTextp2Life.setEditable(false);
        
        changeHealthP1.setBounds(30,60, 370,30); //x axis, y axis, width, height  
        changeHealthP2.setBounds(30,260, 370,30);
        
        JTextp1IsProtected.setBounds(30,90, 370,30); //x axis, y axis, width, height  
        JTextp2IsProtected.setBounds(30,290, 370,30);
        JTextp1IsProtected.setEditable(false);
        JTextp2IsProtected.setEditable(false);
        
        JTextp1BurnCounter.setBounds(30,120, 370,30); //x axis, y axis, width, height  
        JTextp2BurnCounter.setBounds(30,320, 370,30);
        JTextp1BurnCounter.setEditable(false);
        JTextp2BurnCounter.setEditable(false);
        
                  
        devconsole.setSize(400,500);//400 width and 500 height  
        devconsole.setLayout(null);//using no layout managers  
        devconsole.setVisible(true);//making the frame visible  
        devconsole.setResizable(false); //cant resize it
        
        devconsole.add(JTextnameP1);
        devconsole.add(JTextnameP2);
        devconsole.add(JTextp1Life);
        devconsole.add(JTextp2Life);
        devconsole.add(changeHealthP1);
        devconsole.add(changeHealthP2);
        devconsole.add(JTextp1IsProtected);
        devconsole.add(JTextp2IsProtected);
        devconsole.add(JTextp1BurnCounter);
        devconsole.add(JTextp2BurnCounter);
        
        changeHealth(changeHealthP1, CharacterCreation.input1);
        changeHealth(changeHealthP2, CharacterCreation.input2);
    }
    
    public static void CloseWindow() {
       System.exit(0);
    }
    
    public static void UpdateWindow() {
        p1Life = CharacterCreation.input1.getLife();
        p2Life = CharacterCreation.input2.getLife();
        p1IsProtected = CharacterCreation.input1.getIsProtected();
        p2IsProtected = CharacterCreation.input2.getIsProtected();
        p1BurnCounter = CharacterCreation.input1.getBurnCounter();
        p2BurnCounter = CharacterCreation.input2.getBurnCounter();
        
        JTextp1Life.setText("Health: " + p1Life);
        JTextp2Life.setText("Health: " + p2Life);
        JTextp1IsProtected.setText("Is Protected: " + p1IsProtected);
        JTextp2IsProtected.setText("Is Protected: " + p2IsProtected);
        JTextp1BurnCounter.setText("BurnCounter for enemy: " + p1BurnCounter);
        JTextp2BurnCounter.setText("BurnCounter for enemy: " + p2BurnCounter);
    }
    
    public void changeHealth(JButton button, Character player) {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    new changeHealthWindow(player);
                  }
           }
        });
    }
}