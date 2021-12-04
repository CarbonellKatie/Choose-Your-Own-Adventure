package com.basePackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


//class to handle all GUI methods, only method that needs to be called from the outside is createGUI once in main and
//setImage when we move to the next gameNode
//Main class does not need to know about anything that happens here, just needs to create the gui and tell it to change picture
public class GUI {
    private static JFrame frame;
    private static JPanel panel;
    private static ImageIcon imageIcon;
    private static JButton OP1Button;
    private static JButton OP2Button;

    //create a JPanel and set it on the JFrame, called once in the main method
    public static void createGUI(String defaultImageFileName){
        frame = new JFrame();
        panel = new JPanel();
        OP1Button = new JButton("Left");
        OP2Button = new JButton("Right");
        panel.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        setImage(defaultImageFileName);

    }

    public static void updateButtonNames(String OP1ButtonName, String OP2ButtonName){
        OP1Button.setName(OP1ButtonName);
        OP2Button.setName(OP2ButtonName);
    }

    //displays image with the given filename on JPanel
    public static void setImage(String filename){
        imageIcon = new ImageIcon(filename);

        //imageIcon must be added when JLabel is constructed and cannot be changed
        JLabel label = new JLabel(imageIcon);

        panel.add(label, BorderLayout.NORTH);
        //panel.removeAll();

        JButton button = new JButton("Right?");
        panel.add(button, BorderLayout.SOUTH);
        panel.setVisible(true);
        frame.pack();
    }
}
