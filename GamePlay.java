package com.basePackage;

import java.io.*;
import java.util.HashMap;

/* Notes:
        *Node IDs start at 1, not 0
 */


public class GamePlay {

    private static HashMap<Integer, GameNode> gameMap;
    private static GameNode currentNode;

    public static void main(String[] args) throws IOException {

        gameMap = new HashMap<Integer, GameNode>();
        readFile("CYOA choices.txt");

        GUI.createGUI("WelcomeScreen.PNG");
    }

    public static void playGame() {

        currentNode = gameMap.get(1);

        //have the GUI display the contents of the first node
        GUI.updateGUI(currentNode);
    }
    //move to the next node according to which button was pressed
    public static void leftButtonPressed() {
        currentNode = gameMap.get(currentNode.getNextLeft());

        //if the current Node is not an end node (meaning it is the last node you visit before you die or win),
        //update the GUI to display the componenets of this node
        if (currentNode.getNodeID() > 0) {
            GUI.updateGUI(currentNode);
        } else {
            GUI.updateGUIEnd(currentNode);
        }
    }

    public static void rightButtonPressed() {
        currentNode = gameMap.get(currentNode.getNextRight());

        if (currentNode.getNodeID() > 0) {
            GUI.updateGUI(currentNode);
        } else {
            GUI.updateGUIEnd(currentNode);
        }
    }


    //reads in file data to fill the HashMap that will be used in the game
    public static void readFile(String filename) throws IOException {

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);


        int ID = -1;
        String prompt = "";
        String leftButtonTitle = "";
        String rightButtonTitle = "";
        int leftNextNodeID = -1;
        int rightNextNodeID = -1;
        String backgroundImage = "";


        //assuming every node has its correct information
        while(br.readLine() != null){  //check if there is a line separator indicating the presence of another node after the current one

            //read in input from file
        try{
            ID = Integer.parseInt(br.readLine());
            prompt = br.readLine();
            leftButtonTitle = br.readLine();
            rightButtonTitle = br.readLine();
            leftNextNodeID = Integer.parseInt(br.readLine());
            rightNextNodeID = Integer.parseInt(br.readLine());
            backgroundImage = br.readLine();
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        //construct a new gameNode from file data
           GameNode gameNode = new GameNode(ID, prompt, backgroundImage, leftButtonTitle, rightButtonTitle, leftNextNodeID, rightNextNodeID);
            gameMap.put(gameNode.getNodeID(), gameNode);

        }

        br.close();
        fr.close();
    }


}
