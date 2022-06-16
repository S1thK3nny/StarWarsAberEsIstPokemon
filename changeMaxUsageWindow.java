import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeMaxUsageWindow {
    private JTextField input;
    public changeMaxUsageWindow(Character player, int id) {
        JFrame CMUW =new JFrame("MaxUse");//creating instance of JFrame 
        
        input = new JTextField(16);
        JButton button = new JButton("Submit");
        
        input.setBounds(0,0,150,25);
        button.setBounds(150,0,100,25);
        
        CMUW.setSize(250,60);//250 width and 60 height  
        CMUW.setLayout(null);//using no layout managers  
        CMUW.setVisible(true);//making the frame visible  
        CMUW.setResizable(false);
        
        CMUW.add(input);
        CMUW.add(button);
        submit(CMUW, button, player, id);
    }
    
    public void submit(JFrame frame, JButton button, Character player, int id)
    {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    int maxuse = Integer.parseInt(input.getText());
                    player.setItemDevMaxUses(id, maxuse);
                    DeveloperConsole.UpdateWindow();
                    frame.dispose();
                    //System.exit(0);
                 }
           }
         });
    }
}
