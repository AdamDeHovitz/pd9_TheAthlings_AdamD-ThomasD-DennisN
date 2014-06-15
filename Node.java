public class Node{

    private TreeObject thing;
    private String question;
    private boolean isQuestion;
    private Node right;
    private Node left;
    private int place;
    private boolean isVoid;

    public Node() {
	right = null;
	left = null;
	isVoid = false;
    }
    public boolean isVoid(){
	return isVoid();
    }
    
    public int getPlace(){
	return place;
    }
    
    public boolean isQuestion(){
	return isQuestion;
    }
    public void setVoid(){
	isVoid = true;
    }

    public void setTreeObject(TreeObject add){
	thing = add;
	isQuestion = false;
    }
    public void setQuestion(String add, int placement){
	isQuestion = true;
	question = add;
	place = placement;
    }
    public TreeObject getTreeObject(){
	return thing;
    }
    public String getQuestion(){
	return question;
    }

    public Node getLeft() 
    {
	return left;
    }
    public Node getRight() 
    {
	return right;
    }
    public void setLeft( Node theNewLeft ) 

    {
	left = theNewLeft;
    }    
    public void setRight( Node theNewRight ) 
    {
	right = theNewRight;
    }
    public String toString() {
	if (isQuestion){
	    return question;}
	else {
	    return thing.toString();
	}
    }


    


}

