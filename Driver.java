import java.util.Scanner; 

// Barebones driver: infastructure roughly in place



public class Driver{
    private Tree _main;
    
    public class Game{
	Tree _main = new Tree();
	Object[] returnLists = FileProc.readFile("fileproctest.txt");
	ArrayList<String> attributeList = (ArrayList<String>) returnLists[0];
	ArrayList<TreeObject> objectList = (ArrayList<TreeObject>) returnLists[1];
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
	    String select = scan.next();
	    if (select == 1)
		_main.playRound();

	    else if(select == 2)
		saveQuit();
	    else if (select == 3)
		break;
	}
    }

    public static void main(String[] args){
	Game play = new Game();
	play.play();
    }
}
