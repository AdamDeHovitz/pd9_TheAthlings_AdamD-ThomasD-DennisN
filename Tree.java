import java.util.ArrayList;

public class Tree{

    private Node _root;
    //private Node _current;

    
    

    public Tree(){
	//_current = _root;
    }

    //public Node getCurrentLeft()
    //{
	//return _current.getLeft()
    public Node getRoot(){
	return _root;
    }
    public void counterUpdate(int[] counter, ArrayList<TreeObject> things){
	
	for (TreeObject paul: things){
	    ArrayList<Integer> attribs = paul.getAttributes();
	    //System.out.println(attribs);
	    for(int x = 0; x < counter.length; x++){
		//System.out.println(x);
		if (attribs.get(x) == 1){
		    //System.out.print(x);
		    counter[x] = counter[x] + 1;
		}
	    }
	    
	}
    }
	

    public void treeCreate(ArrayList<String> attributes, ArrayList<TreeObject> things){
	System.out.println("start of tree creation");
	//	System.out.println(things.get(2));
	//int[] counter = new int[attributes.size()];
	//counterUpdate(counter, things)
	/*for (int q: counter){
	  System.out.print(q + ", ");
	  }*/
	
	_root = treeHelper( attributes, things); //Starts the tree;
	
    }
    public Node treeHelper(  ArrayList<String> attributes, ArrayList<TreeObject> things){

	int[] counter = new int[attributes.size()];
	counterUpdate(counter, things);
	Node node = new Node();
	/*if (things.size() == 0){
	    node.setVoid();
	    return node;
	    }*/
	if (things.size() == 1){   //If there is one object left, place it in as a leaf
	    node.setTreeObject(things.remove(0));
	    return node;
	}
	int x = things.size() / 2;
	if (things.size() < 5){
	    for (int qp: counter)
		System.out.print(qp + ", ");
	}
	int mostMid = 0; 
	for (int d = 1; d < counter.length; d++){
	    if (counter[mostMid] == 0 && counter[d] != 0){ //super specific case
		mostMid=d;}
	    else if ( counter[d] != 0 && Math.abs(x - counter[d]) < Math.abs( x - counter[mostMid])){  //Find the most divisive question
		mostMid = d; 
	    }
	}
	//System.out.println(mostMid);
	counter[mostMid] = 0;
	node.setQuestion(attributes.get(mostMid), mostMid);
	ArrayList<TreeObject> yes = new ArrayList<TreeObject>();
	ArrayList<TreeObject> no = new ArrayList<TreeObject>();
	for (TreeObject henry : things){
	    if( henry.getAttributeAt(mostMid) == 1){
		yes.add(henry);}
	    else{
		no.add(henry);
	    }
	}
	System.out.println("Objects that have " + attributes.get(mostMid) + ": " + yes);
	System.out.println("Objects that don't have " + attributes.get(mostMid) + ": " + no);

	node.setLeft(treeHelper(/*counter,*/ attributes, yes)); //Creating children
	node.setRight(treeHelper(/*counter,*/ attributes, no));   //Creating children

	return node;
    }


    
    public void preOrderTrav() {
	preOrderTrav( _root );
    }
    public void preOrderTrav( Node currNode ) {
	if ( currNode == null )
	    return;
	System.out.print( currNode.toString() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }


}