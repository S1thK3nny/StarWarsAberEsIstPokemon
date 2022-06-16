import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class changeItemsWindow { //DIE ALLE MÜSSEN AUSGEFÜLLT SEIN; SONST NULL POINTER EXCEPTION!!!
    private JList list;
    private static String item1 = "default";
    private static String item2 = "default";
    private static String item3 = "default";
    private static String item4 = "default";
    private static int tempuse1 = 0;
    private static int tempuse2 = 0;
    private static int tempuse3 = 0;
    private static int tempuse4 = 0;
    private static int maxuse1 = 0;
    private static int maxuse2 = 0;
    private static int maxuse3 = 0;
    private static int maxuse4 = 0;
    private JTextField input;
    static Character player = new Character();
    private static JLabel playerItem1 = new JLabel("Item 1: " + "(" + tempuse1 + "/" + maxuse1 + ") " + item1);
    private static JLabel playerItem2 = new JLabel("Item 2: " + "(" + tempuse2 + "/" + maxuse2 + ") " + item2);
    private static JLabel playerItem3 = new JLabel("Item 3: " + "(" + tempuse3 + "/" + maxuse3 + ") " + item3);
    private static JLabel playerItem4 = new JLabel("Item 4: " + "(" + tempuse4 + "/" + maxuse4 + ") " + item4);
    public changeItemsWindow(Character player) {
        this.player = player;
        JFrame CIW = new JFrame("Items");//creating instance of JFrame 
        JPanel panel = new JPanel();
        JLabel exp = new JLabel("Select the preferred Item and press on the corresponding submit button");
        
        item1 = player.getItems()[0].name;
        item2 = player.getItems()[1].name;
        item3 = player.getItems()[2].name;
        item4 = player.getItems()[3].name;
        tempuse1 = player.getItemTempUses()[0];
        tempuse2 = player.getItemTempUses()[1];
        tempuse3 = player.getItemTempUses()[2];
        tempuse4 = player.getItemTempUses()[3];
        maxuse1 = player.getItemMaxUses()[0];
        maxuse2 = player.getItemMaxUses()[1];
        maxuse3 = player.getItemMaxUses()[2];
        maxuse4 = player.getItemMaxUses()[3];
        
        playerItem1 = new JLabel("Item 1: " + "(" + tempuse1 + "/" + maxuse1 + ") " + item1);
        playerItem2 = new JLabel("Item 2: " + "(" + tempuse2 + "/" + maxuse2 + ") " + item2);
        playerItem3 = new JLabel("Item 3: " + "(" + tempuse3 + "/" + maxuse3 + ") " + item3);
        playerItem4 = new JLabel("Item 4: " + "(" + tempuse4 + "/" + maxuse4 + ") " + item4);
        
        input = new JTextField(16);
        
        DefaultListModel<String> Items = new DefaultListModel<>(); 
        
        for(int i=0; i<CharacterCreation.Items.length; i++) {
            Items.addElement(CharacterCreation.Items[i].name);
        }
        panel.setSize(600,500);
        list = new JList<>(Items);
        JButton button1 = new JButton("Submit");
        JButton button2 = new JButton("Submit");
        JButton button3 = new JButton("Submit");
        JButton button4 = new JButton("Submit");
        
        JButton tempbutton1 = new JButton("Change Tempusage");
        JButton tempbutton2 = new JButton("Change Tempusage");
        JButton tempbutton3 = new JButton("Change Tempusage");
        JButton tempbutton4 = new JButton("Change Tempusage");
        JButton maxbutton1 = new JButton("Change Maxusage");
        JButton maxbutton2 = new JButton("Change Maxusage");
        JButton maxbutton3 = new JButton("Change Maxusage");
        JButton maxbutton4 = new JButton("Change Maxusage");
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        CIW.setSize(600,500);  
        CIW.setVisible(true);//making the frame visible  
        CIW.setResizable(false);
        
        panel.add(playerItem1);
        panel.add(button1);
        panel.add(tempbutton1);
        panel.add(maxbutton1);
        
        panel.add(playerItem2);
        panel.add(button2);
        panel.add(tempbutton2);
        panel.add(maxbutton2);
        
        panel.add(playerItem3);
        panel.add(button3);
        panel.add(tempbutton3);
        panel.add(maxbutton3);
        
        panel.add(playerItem4);
        panel.add(button4);
        panel.add(tempbutton4);
        panel.add(maxbutton4);
        
        panel.add(list);
        panel.add(exp);
        
        CIW.add(panel);
        
        submit(button1, 0, player);
        submit(button2, 1, player);
        submit(button3, 2, player);
        submit(button4, 3, player);
        
        changeTempUsage(tempbutton1, 0, player);
        changeTempUsage(tempbutton2, 1, player);
        changeTempUsage(tempbutton3, 2, player);
        changeTempUsage(tempbutton4, 3, player);
        
        changeMaxUsage(maxbutton1, 0, player);
        changeMaxUsage(maxbutton2, 1, player);
        changeMaxUsage(maxbutton3, 2, player);
        changeMaxUsage(maxbutton4, 3, player);
    }
    
    public void submit(JButton button, int id, Character player)
    {
         button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    int index = list.getSelectedIndex();
                    if (index < 0){
                        return;
                    }
                    else{
                        player.setItem(id, CharacterCreation.Items[list.getSelectedIndex()]);
                    }
                    DeveloperConsole.UpdateWindow();
                 }
           }
         });
    }
    
    public void changeTempUsage(JButton button, int id, Character player) {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    new changeTempUsageWindow(player, id);
                  }
           }
        });
    }
    
    public void changeMaxUsage(JButton button, int id, Character player) {
        button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent buttonpress) {
                 // this makes sure the button you are pressing is the button variable
                 if(buttonpress.getSource() == button) {
                    new changeMaxUsageWindow(player, id);
                  }
           }
        });
    }
    
    public static void UpdateCIW() {
        item1 = player.getItems()[0].name;
        item2 = player.getItems()[1].name;
        item3 = player.getItems()[2].name;
        item4 = player.getItems()[3].name;
        tempuse1 = player.getItemTempUses()[0];
        tempuse2 = player.getItemTempUses()[1];
        tempuse3 = player.getItemTempUses()[2];
        tempuse4 = player.getItemTempUses()[3];
        maxuse1 = player.getItemMaxUses()[0];
        maxuse2 = player.getItemMaxUses()[1];
        maxuse3 = player.getItemMaxUses()[2];
        maxuse4 = player.getItemMaxUses()[3];
        playerItem1.setText("Item 1: " + "(" + tempuse1 + "/" + maxuse1 + ") " + item1);
        playerItem2.setText("Item 2: " + "(" + tempuse2 + "/" + maxuse2 + ") " + item2);
        playerItem3.setText("Item 3: " + "(" + tempuse3 + "/" + maxuse3 + ") " + item3);
        playerItem4.setText("Item 4: " + "(" + tempuse4 + "/" + maxuse4 + ") " + item4);
    }
}