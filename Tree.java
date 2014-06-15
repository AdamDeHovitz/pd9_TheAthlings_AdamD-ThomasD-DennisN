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
	//	System.out.println(things.get(2));
	//int[] counter = new int[attributes.size()];
	//counterUpdate(counter, things)
	/*for (int q: counter){
	  System.out.print(q + ", ");
	  }*/
	
	_root = treeHelper(/*counter,*/ attributes, things); //Starts the tree;
	
    }
    public Node treeHelper( /*int[] counter*/ ArrayList<String> attributes, ArrayList<TreeObject> things){
	int[] counter = new int[attributes.size()];
	counterUpdate(counter, things);
	    Node node = new Node();
	if (things.size() == 1){   //If there is one object left, place it in as a leaf
	    node.setTreeObject(things.remove(0));
	    return node;
	}
	int x = things.size() / 2;
	//for (int q: counter){
	//  System.out.print(q + ", ");
	//}
	int mostMid = 0; 
	for (int d = 1; d < counter.length; d++){ 
	    if ( Math.abs(x - counter[d]) < Math.abs( x - counter[mostMid])){  //Find the most divisive question
		mostMid = d; 
	    }
	}
	//System.out.println(mostMid);
	counter[mostMid] = 0;
	node.setQuestion(attributes.get(mostMid));
	ArrayList<TreeObject> yes = new ArrayList<TreeObject>();
	ArrayList<TreeObject> no = new ArrayList<TreeObject>();
	for (TreeObject henry : things){
	    if( henry.getAttributeAt(mostMid) == 1){
		yes.add(henry);}
	    else{
		no.add(henry);
	    }
	}
	

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