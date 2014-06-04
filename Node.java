public class Node{

    private TreeObject thing;
    private String question;
    private boolean isQuestion;
    private Node right;
    private Node left;

    public Node() {
	right = null;
	left = null;
    }
    
    public boolean isQuestion(){
	return isQuestion;
    }

    public void setTreeObject(TreeObject add){
	thing = add;
	isQuestion = false;
    }
    public void setQuestion(String add){
	isQuestion = true;
	ask = add;
    }
    public TreeObject getTreeObject(){
	return thing;
    }
    public Question getQuestion(){
	return question;
    }

    public TreeNode getLeft() 
    {
	return left;
    }
    public TreeNode getRight() 
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

