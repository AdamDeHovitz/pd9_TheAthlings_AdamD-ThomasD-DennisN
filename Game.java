import java.util.*;

// Barebones driver: infastructure roughly in place

public class Game{
	
	
    private Tree _main;
    private ArrayList<String> attributeList;
    private ArrayList<TreeObject> objectList;
    
    public Game(){
	_main  = new Tree(); 
	System.out.println("Welcome to guess your item!");
	String fileName = UserProc.readStringInput("Which save-file would you like to open? (if you want to load the default file, type in 'animalsTest.txt')");
	while (!FileProc.fileExists(fileName))
	{
		System.out.println("File does not exist.");
		fileName = UserProc.readStringInput("Which save-file would you like to open? (if you want to load the default file, type in 'animalsTest.txt')");
	}
	Object[] returnLists = FileProc.readFile(fileName);
	attributeList = (ArrayList<String>) returnLists[0];
	objectList = (ArrayList<TreeObject>) returnLists[1];
	//System.out.println("Attributes: " + attributeList);
	//System.out.println("Objects: " + objectList);
	_main.treeCreate(attributeList, objectList);
	
    }
    public void printMain(){ //Prints out the main options
	String ret="\t 1: Play a game \n\t 2: Save and quit \n\t 3: Quit" /*\n\t 4: View Current War*/;
	System.out.println( ret);
    }
    
    public ArrayList getattributeList(){
    	return attributeList;
    }
    
    public void play(){  //Plays the game, as long as this method loops the game continues.

	

	boolean EndGame=false;
	while(!EndGame){
	   
	   printMain();

	    // read what the user types
	    int select = Integer.parseInt(UserProc.readStringInput("Choose an option"));
	    if (select == 1)
		playRound();
		//new GuiApp(_main.getRoot());

	    else if(select == 2)
	    {
			saveQuit();
			break;
		}
	    else if (select == 3)
	    {
			break;
		}
	}
    }
    public void playRound(){
	ArrayList<Integer> properties = new ArrayList<Integer>();
	for (int x = 0; x < attributeList.size(); x++){
	    properties.add(-1);
	}
	playRoundHelper(_main.getRoot(), properties);
    }
    public void playRoundHelper(Node current, ArrayList<Integer> properties){
	/*if (current.isVoid()){
	  System.out.println("We don't have you object");
	  createNew(properties);
	  }*/
	if (current.isQuestion()){
	    //System.out.println(current);
	    if (UserProc.readBinaryInput(current.getQuestion())){
		properties.set(current.getPlace(), 1);
		playRoundHelper(current.getLeft(), properties);
	    }
	    else{
		properties.set(current.getPlace(), 0);
		playRoundHelper(current.getRight(), properties);
		
	    }
	}
	else if (! UserProc.readBinaryInput("Is it a " + current.getTreeObject().getName())){
	    createNew(properties);
	}
	else {
	    System.out.println("Aren't I smart?\nPlay again!");
	}
    }
    
    public void createNew(ArrayList<Integer> properties){
	System.out.println("\nI'm going to need you to define your new object so that I can include it into my database");
	// read what the user types
	String name = UserProc.readStringInput("Name");

	for(int x = 0; x < properties.size(); x++){
	    if (properties.get(x) == -1){
		if (UserProc.readBinaryInput(attributeList.get(x))){
		    properties.set(x, 1);}
		else{
		    properties.set(x, 0);}
	    }
	} 
	TreeObject novel = new TreeObject(name, properties);
	objectList.add(novel);
	for(TreeObject pavel: objectList){
	    
	    if ( ( !pavel.getName().equals(name)) && pavel.getAttributes().equals(properties)){
		newAttribute(novel, pavel);
		return;
	    }
	}
	//TreeObject novel = new TreeObject(name, properties);
	System.out.println(name+ " has been added to my information");
	_main.treeCreate(attributeList, objectList);

    }
    public void newAttribute( TreeObject novel, TreeObject conflict){
	System.out.println("I've detected that your " + novel.getName() + " is identical to my defined " + conflict.getName() + " based on the existing attributes\nPlease give me a new attribute in the form of \"Is it <x>?\" (for example \"Is it furry\"): ");
	// read what the user types
	String question = UserProc.readStringInput("Enter the new attribute in the form specified");
	attributeList.add(question);
	System.out.println("I am now going to ask you to define every other object using this attribute. If you give the same answer for " + novel.getName() + " and "  + conflict.getName() + " there will be a problem");
	for (TreeObject henry: objectList){
	    System.out.print(henry.getName() + ": ");
	    if( UserProc.readBinaryInput(question)){
		henry.addToAttributes(1);
	    }
	    else{
		henry.addToAttributes(0);
	    }
	}
	System.out.println("My information has been updated to reflect your input. Thank you");
	_main.treeCreate(attributeList, objectList);
    }
	
    


    
    public void saveQuit()
    {
    	Object[] saveLists = new Object[] {attributeList, objectList};	
    	String fileName = UserProc.readStringInput("Which file would you like to save to? (enter filenames like this \'animalsTest.txt\')");
		FileProc.saveToFile(fileName, saveLists);

    }

    
}
