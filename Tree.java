import java.util.ArrayList;

public class Tree{

    public Node _root;
    

    public class Tree() {
    }

    public void treeCreate(ArrayList<String> attributes, ArrayList<TreeObject> things){
	int[] counter = new int[attributes.size()];
	for (TreeObject paul: things){
	    ArrayList<Integer> attribs = paul.getAttributes();
	    int x = 0;
	    for(; x < things.size(); x++){
		if (attribs.get(x) == 1){
		    counter[x] = counter[x] + 1;
		}
	    }
	    
	}
    
	treeHelper(counter, things, attributes,)
	
    }
    public Node treeHelper( int[] counter, ArrayList<String> attributes, ArrayList<TreeObject> things){
	Node node = new Node();
	if (things.size() == 1){
	    node.addObject(things.remove());
	    return node;
	}
	int x = things.size() / 2;
	int mostMid = 0;
	for (int d = 1; d < counter.length; d++){
	    if ( abs(x - counter[d]) < abs( x - counter[mostMid])){
		mostMid = d;
	    }
	}
	counter[mostMid] = 0;
	node.addQuestion(attributes.get(mostMid));
	ArrayList<TreeObjects> yes = new ArrayList<TreeObjects>();
	ArrayList<TreeObjects> no = new ArrayList<TreeObjects>();
	for (TreeObject henry : things){
	    if( henry.getAttributeAt(mostMid) = 1){
		yes.add(henry);}
	    else{
		no.add(henry);
	    }
	}
	

	node.setRight(counter, attributes, yes);
	node.setLeft(counter, attributes, no);

	return node;
}