package com.basePackage;

import com.basePackage.GameNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//class to handle all com.basePackage.GUI methods, only method that needs to be called from the outside is createGUI once in main and
//setImage when we move to the next gameNode
//Main class does not need to know about anything that happens here, just needs to create the gui and tell it to change picture
public class GUI implements ActionListener {
    private static JFrame frame;
    private static ImageIcon imageIcon;
    private static JButton OP1Button;
    private static JButton OP2Button;
    private static JLabel pictureLabel = new JLabel();
    private static JLabel promptLabel;

    public static void createGUI(String welcomePicture, GameNode firstNode){
        frame = new JFrame();

        JButton playButton = new JButton("Play");
        Dimension dimension = new Dimension(300, 50);
        playButton.setPreferredSize(dimension);
        frame.add(playButton, BorderLayout.SOUTH);
        setImage(welcomePicture);
        frameInit();
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createGameGUI();
            }
    });
    }

    //create the com.basePackage.GUI for the remainder of the game
    public static void createGameGUI(){
        frame.removeAll();

        OP1Button = new JButton();
        OP2Button = new JButton();
        Dimension dimension = new Dimension(150, 50);
        OP1Button.setPreferredSize(dimension);
        OP2Button.setPreferredSize(dimension);

        promptLabel = new JLabel("prompt here");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());

        panel.add(OP1Button, BorderLayout.LINE_START);
        panel.add(OP2Button, BorderLayout.LINE_END);
        panel.add(promptLabel, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frameInit();

        GamePlay.playGame();
        //setImage(firstNode.getImage());
    }

    public static void frameInit(){
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void updateGUI(GameNode currentNode){
        updateButtonNames(currentNode.getOp1ButtonName(), currentNode.getOp2ButtonName());
        setImage(currentNode.getImage());

    }

    public static void updateButtonNames(String OP1ButtonName, String OP2ButtonName){
        OP1Button.setName(OP1ButtonName);
        OP2Button.setName(OP2ButtonName);
    }

    public static void setPrompt(String prompt){
        promptLabel.setText(prompt);
    }


    //displays image with the given filename on JPanel
    public static void setImage(String filename){
        frame.remove(pictureLabel);
        imageIcon = new ImageIcon(filename);

        //imageIcon must be added when JLabel is constructed and cannot be changed
        pictureLabel = new JLabel(imageIcon);
        frame.add(pictureLabel, BorderLayout.NORTH);

        frameInit();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == OP1Button){

        }
    }
}
