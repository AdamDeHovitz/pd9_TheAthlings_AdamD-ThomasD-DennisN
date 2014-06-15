import java.util.*;

// Barebones driver: infastructure roughly in place

public class Game{
	
	
    private Tree _main;
    
    public Game(){
	_main  = new Tree();
	Object[] returnLists = FileProc.readFile("animalsTest.txt");
	ArrayList<String> attributeList = (ArrayList<String>) returnLists[0];
	ArrayList<TreeObject> objectList = (ArrayList<TreeObject>) returnLists[1];
	System.out.println("Attributes: " + attributeList);
	System.out.println("Objects: " + objectList);
	_main.treeCreate(attributeList, objectList);
    }
    public void printMain(){ //Prints out the main options
	String ret="\t 1: Play a game \n\t 2: Save and quit \n\t 3: Quit" /*\n\t 4: View Current War*/;
	System.out.println( ret);
    }
    
    public void play(){  //Plays the game, as long as this method loops the game continues.

	System.out.println("Welcome to guess your item!");

	boolean EndGame=false;
	while(!EndGame){
	   
	   
	    System.out.println("Choose an option");
	    printMain();
	    
		// create a Scanner object to read from the keyboard
		Scanner scan = new Scanner(System.in);

	    // read what the user types
	    int select = scan.nextInt();
	    if (select == 1)
		playRound();

	    else if(select == 2)
		saveQuit();
	    else if (select == 3)
		break;
	}
    }
    public void playRound(){
	playRoundHelper(_main.getRoot());
    }
    public void playRoundHelper(Node current){
	if (current.isQuestion()){
	    //System.out.println(current);
	    if (UserProc.readInput(current.getQuestion())){
		playRoundHelper(current.getLeft());
	    }
	    else{
		playRoundHelper(current.getRight());
	    }
	}
	else{
	    System.out.println("Is it a " + current.getTreeObject().toString());
	}
    }
    public void saveQuit(){
	//implemented by Dennis
    }

    
}