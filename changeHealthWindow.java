import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changeHealthWindow {
    private JTextField input;
    public changeHealthWindow(Character player) {
        JFrame CHW =new JFrame("Health");//creating instance of JFrame 
        
        input = new JTextField(16);
        JButton button = new JButton("Submit");
        
        input.setBounds(0,0,150,25);
        button.setBounds(150,0,100,25);
        
        CHW.setSize(250,60);//250 width and 75 height  
        CHW.setLayout(null);//using no layout managers  
        CHW.setVisible(true);//making the frame visible  
        CHW.setResizable(false);
        
        CHW.add(input);
        CHW.add(button);
        submit(CHW, button, player);
    }
    
    public void submit(JFrame frame, JButton button, Character player)
    {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    int life = Integer.parseInt(input.getText());
                    player.setLife(life);
                    DeveloperConsole.UpdateWindow();
                    frame.dispose();
                    //System.exit(0);
                 }
           }
         });
    }
}