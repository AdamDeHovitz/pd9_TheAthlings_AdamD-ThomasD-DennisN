import java.util.ArrayList;



public class TreeTester{

    public static void main(String[] args){
	Tree paul = new Tree();
	//Object[] returnLists = FileProc.readFile("fileproctest.txt");
	//ArrayList<String> attributeList = (ArrayList<String>) returnLists[0];
	//ArrayList<TreeObject> objectList = (ArrayList<TreeObject>) returnLists[1];
	
	ArrayList<Integer> testArray = new ArrayList<Integer>();
	testArray.add(1);
	testArray.add(0);
	testArray.add(0);
	TreeObject testObject1 = new TreeObject("Object 1", testArray)
;
	ArrayList<Integer> testArray2 = new ArrayList<Integer>();
	testArray2.add(0);
	testArray2.add(1);
	testArray2.add(0);
	TreeObject testObject2 = new TreeObject("Object 2", testArray2);

	ArrayList<Integer> testArray3 = new ArrayList<Integer>();
	testArray3.add(0);
	testArray3.add(1);
	testArray3.add(1);
	TreeObject testObject3 = new TreeObject("Object 3", testArray3);
	
	ArrayList<TreeObject> objectList = new ArrayList<TreeObject>();
	objectList.add(testObject1);
	objectList.add(testObject2);
	objectList.add(testObject3);
	ArrayList<String> attributeList = new ArrayList<String>();
	attributeList.add("Is it Red?");
	attributeList.add("Is it Tall?");
	attributeList.add("Is it Cool?");
	
	System.out.println(testObject1 ); //+ " attribs: " + testObject1.getAttributes());
	System.out.println(testObject2 ); //+  " attribs: " + testObject2.getAttributes() );
	System.out.println(testObject3 ); //+  " attribs: " + testObject3.getAttributes());
	
	paul.treeCreate(attributeList, objectList);
	paul.preOrderTrav();

	
    }
}