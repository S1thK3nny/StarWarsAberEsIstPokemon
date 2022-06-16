import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeTempUsageWindow {
    private JTextField input;
    public changeTempUsageWindow(Character player, int id) {
        JFrame CTUW =new JFrame("TempUse");//creating instance of JFrame 
        
        input = new JTextField(16);
        JButton button = new JButton("Submit");
        
        input.setBounds(0,0,150,25);
        button.setBounds(150,0,100,25);
        
        CTUW.setSize(250,60);//250 width and 60 height  
        CTUW.setLayout(null);//using no layout managers  
        CTUW.setVisible(true);//making the frame visible  
        CTUW.setResizable(false);
        
        CTUW.add(input);
        CTUW.add(button);
        submit(CTUW, button, player, id);
    }
    
    public void submit(JFrame frame, JButton button, Character player, int id)
    {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    int tempuse = Integer.parseInt(input.getText());
                    player.setItemDevTempUses(id, tempuse);
                    DeveloperConsole.UpdateWindow();
                    frame.dispose();
                    //System.exit(0);
                 }
           }
         });
    }
}
