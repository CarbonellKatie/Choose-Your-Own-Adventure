package com.basePackage;

import javax.swing.*;

public class GameNode {

    private int nodeID;
    private String prompt;

    private static JFrame frame = new JFrame();
    private static JPanel graphicsPanel = new JPanel();         //TODO: add in name of background image later
    private String backgroundImage;

    private String leftButtonName;
    private int nextLeft;  //location of next node if the option 1 button is pressed
    private String rightButtonName;
    private int nextRight;   //location of next Node in the hashTable if option 2 button is pressed

    //go to next node when right option was chosen
    public void goRight(){

    }
    //return ID of next node if OP1 button is pressed
    public int getNextLeft(){
        return nextLeft;
    }
    //return the ID of the next node if OP2 button is pressed
    public int getNextRight(){
        return nextRight;
    }

    //go to next node when left option was chosen
    public void goLeft(){

    }
    public int getNodeID(){
        return nodeID;
    }
    public String getPrompt(){
        return prompt;
    }
    public String getLeftButtonName(){
        return leftButtonName;
    }
    public String getRightButtonName(){
        return rightButtonName;
    }
    public String getImage(){
        return backgroundImage;
    }

    public GameNode(){
        //TODO: Delete later
    }

    public GameNode(int nodeID, String prompt, String backgroundImage, String leftButtonName, String rightButtonName, int nextLeft, int nextRight) {
        this.nodeID = nodeID;
        this.prompt = prompt;
        this.backgroundImage = backgroundImage;
        this.leftButtonName = leftButtonName;
        this.nextLeft = nextLeft;
        this.rightButtonName = rightButtonName;
        this.nextRight = nextRight;
    }
}
