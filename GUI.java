package com.basePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


//class to handle all com.basePackage.GUI methods, only method that needs to be called from the outside is createGUI once in main and
//setImage when we move to the next gameNode
//Main class does not need to know about anything that happens here, just needs to create the gui and tell it to change picture
public class GUI {
    private static JFrame frame = new JFrame();
    private static ImageIcon imageIcon;
    private static JButton leftButton;
    private static JButton rightButton;
    private static JLabel pictureLabel = new JLabel();
    private static JLabel promptLabel;
    private static Actionlistener actionlistener;
    private static endActionListener endListener;

    public static void createGUI(String welcomePicture){
        //frame = new JFrame();
        actionlistener = new Actionlistener();
        endListener = new endActionListener();

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
        frame.getContentPane().removeAll();
        frame.repaint();

        leftButton = new JButton();
        rightButton = new JButton();
        Dimension dimension = new Dimension(150, 50);
        leftButton.setPreferredSize(dimension);
        rightButton.setPreferredSize(dimension);
        leftButton.addActionListener(actionlistener);
        rightButton.addActionListener(actionlistener);

        promptLabel = new JLabel("prompt here");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());

        panel.add(leftButton, BorderLayout.LINE_START);
        panel.add(rightButton, BorderLayout.LINE_END);
        panel.add(promptLabel, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.SOUTH);

        frameInit();

        GamePlay.playGame();

    }


    public static void frameInit(){
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void updateGUI(GameNode currentNode){
        updateButtonNames(currentNode.getLeftButtonName(), currentNode.getRightButtonName());
        setImage(currentNode.getImage());
        updatePrompt(currentNode.getPrompt());

    }
    public static void updateGUIEnd(GameNode currentNode){
        updateGUI(currentNode);
        leftButton.removeActionListener(actionlistener);
        rightButton.removeActionListener(actionlistener);
        leftButton.addActionListener(endListener);
        rightButton.addActionListener(endListener);
    }

    public static void updateButtonNames(String leftButtonName, String rightButtonName){
        leftButton.setText(leftButtonName);
        rightButton.setText(rightButtonName);
    }

    public static void updatePrompt(String prompt){
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


    //static class used to create a static Actionlistener object for the GUI's JButtons
    public static class Actionlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == leftButton){
                GamePlay.leftButtonPressed();
            }
            else if(e.getSource() == rightButton){
                GamePlay.rightButtonPressed();
            }
        }
    }
    public static class endActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //if the use pressed play again, call createGUi to create a new GUI and begin at the first GameNode
            if(e.getSource() == leftButton){
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                createGUI("WelcomeScreen.PNG");
            }
            else{
                System.exit(0);
            }
        }
    }
}
