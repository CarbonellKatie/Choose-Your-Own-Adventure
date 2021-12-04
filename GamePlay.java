package com.basePackage;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

/* Notes:
        *Node IDs start at 1, not 0
 */


public class GamePlay {

    private static HashMap<Integer, GameNode> gameMap = new HashMap<Integer, GameNode>();

    public static void main(String[] args) throws IOException {
        //HashMap to store a GameNode by its key (GameNode's ID, GameNode)
       // testing.test();
        readFile("CYOA choices.txt");
        playGame(1);
    }

    public static void playGame(int NodeID){
        //create the GUI, set initial image to welcome screen image
        GUI.createGUI("WelcomeScreen.PNG");

        Scanner stdin = new Scanner(System.in);

        GameNode currentNode = gameMap.get(1);
        //while(currNode.right)
       /* while(currentNode.getNodeID() > 0){
            System.out.println(currentNode.getPrompt());



        }
*/
    }

    //reads in file data to fill the HashMap that will be used in the game
    public static void readFile(String filename) throws IOException {


        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);


        int ID = -1;
        String prompt = "";
        String OP1ButtonTitle = "";
        String OP2ButtonTitle = "";
        int OP1NextNodeID = -1;
        int OP2NextNodeID = -1;
        String backgroundImage = "";


        //assuming every node has its correct information
        while(br.readLine() != null){  //check if there is a line separator indicating the presence of another node after the current one

            //read in input from file
        try{
            ID = Integer.parseInt(br.readLine());
            prompt = br.readLine();
            OP1ButtonTitle = br.readLine();
            OP2ButtonTitle = br.readLine();
            OP1NextNodeID = Integer.parseInt(br.readLine());
            OP2NextNodeID = Integer.parseInt(br.readLine());
            backgroundImage = br.readLine();
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        //construct a new gameNode from file data
            GameNode gameNode = new GameNode(ID, prompt, backgroundImage, OP1ButtonTitle, OP2ButtonTitle, OP1NextNodeID, OP2NextNodeID);
            gameMap.put(gameNode.getNodeID(), gameNode);
        }

        br.close();
        fr.close();
    }


}
