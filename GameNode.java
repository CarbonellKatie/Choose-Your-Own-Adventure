package com.basePackage;

import javax.swing.*;

public class GameNode {

    private int nodeID;
    private String prompt;

    private static JFrame frame = new JFrame();
    private static JPanel graphicsPanel = new JPanel();         //TODO: add in name of background image later
    private String backgroundImage;

    private String Op1ButtonName;
    private int nextOp1;  //location of next node if the option 1 button is pressed
    private String Op2ButtonName;
    private int nextOp2;   //location of next Node in the hashTable if option 2 button is pressed

    //go to next node when right option was chosen
    public void goRight(){

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

    public GameNode(){
        //TODO: Delete later
    }

    public GameNode(int nodeID, String prompt, String backgroundImage, String op1ButtonName, String op2ButtonName, int nextOp1, int nextOp2) {
        this.nodeID = nodeID;
        this.prompt = prompt;
        this.backgroundImage = backgroundImage;
        Op1ButtonName = op1ButtonName;
        this.nextOp1 = nextOp1;
        Op2ButtonName = op2ButtonName;
        this.nextOp2 = nextOp2;
    }
}
