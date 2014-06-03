import java.util.ArrayList;
public class TreeObjectTest
{
	public static void main (String[] args)
	{
		TreeObject testObject1 = new TreeObject();
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		TreeObject testObject2 = new TreeObject("Object 2", testArray);
		//Testing Object 1
		System.out.println("Testing object 1");
		System.out.println(testObject1.getAttributes().toString()); //"[]"
		System.out.println(testObject1.getName().toString()); //"Null"
		testObject1.setAttributes(testArray);
		System.out.println(testObject1.getAttributes().toString()); //"[1,2,3]"
		System.out.println(testObject1.getName().toString()); //"Null"
		System.out.println(testObject1);
		testObject2.clearAttributes();
		System.out.println(testObject1.getAttributes().toString()); //"[]"

		//Testing Object 2
		System.out.println("Testing object 2");
		System.out.println(testObject2.getAttributes().toString()); //"[1,2,3]"
		System.out.println(testObject2.getName().toString()); //"Object 2"
		testArray.add(4);
		testArray.add(5);
		testObject2.setAttributes(testArray);
		System.out.println(testObject2.getAttributes().toString()); //"[1,2,3,4,5]"
		System.out.println(testObject2.getName().toString()); //"Object 2"
		System.out.println(testObject2);
		testObject2.clearAttributes();
		System.out.println(testObject2.getAttributes().toString()); //"[]"

	}
}