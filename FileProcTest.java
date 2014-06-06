import java.util.ArrayList;
public class FileProcTest
{
	public static void fileExistsTest()
	{
		System.out.println("These should all be true");
		System.out.println(FileProc.fileExists("fileproctest.txt"));
		System.out.println(FileProc.fileExists("fileproctest2.txt"));
		System.out.println("These should all be false");
		System.out.println(FileProc.fileExists("doesnotexist.txt"));
		System.out.println(FileProc.fileExists("fileproctest3.txt"));
	}

	public static void seperateByCommaTest()
	{
		String testString1 = "Dennis,Thomas,Adam";
		String testString2 = "1,0,1,1,1,0";
		String testString3 = " Dennis , Thomas , Adam ";
		String testString4 = " 1 , 0 , 1 , 0";
		String testString5 = "Dennis, Thomas, Adam,";

		ArrayList<String> testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString1 + "|");
		FileProc.seperateByCommaS(testString1,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString2 + "|");
		FileProc.seperateByCommaS(testString2,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString3 + "|");
		FileProc.seperateByCommaS(testString3,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString4 + "|");
		FileProc.seperateByCommaS(testString4,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString5 + "|");
		FileProc.seperateByCommaS(testString5,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();
	}

	public static void readFileTest()
	{
		Object[] returnLists = FileProc.readFile("fileproctest.txt");
		ArrayList<String> attributeList = (ArrayList<String>) returnLists[0];
		ArrayList<TreeObject> objectList = (ArrayList<TreeObject>) returnLists[1];
		System.out.println(attributeList);
		System.out.println(objectList);

		returnLists = FileProc.readFile("fileproctest2.txt");
		attributeList = (ArrayList<String>) returnLists[0];
		objectList = (ArrayList<TreeObject>) returnLists[1];
		System.out.println(attributeList);
		System.out.println(objectList);

		returnLists = FileProc.readFile("fileproctest3.txt");
		attributeList = (ArrayList<String>) returnLists[0];
		objectList = (ArrayList<TreeObject>) returnLists[1];
		System.out.println(attributeList);
		System.out.println(objectList);

		returnLists = FileProc.readFile("fileproctest4.txt");
		attributeList = (ArrayList<String>) returnLists[0];
		objectList = (ArrayList<TreeObject>) returnLists[1];
		System.out.println(attributeList);
		System.out.println(objectList);
	}

	public static void insertCommasBetweenTest()
	{
		String testString1 = "Dennis,Thomas,Adam";
		String testString2 = "1,0,1,1,1,0";
		String testString3 = " Dennis , Thomas , Adam ";
		String testString4 = " 1 , 0 , 1 , 0";
		String testString5 = "Dennis, Thomas, Adam,";

		ArrayList<String> testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString1 + "|");
		FileProc.seperateByCommaS(testString1,testList);
		System.out.println("Cleaned string: " + FileProc.insertCommasBetween(testList));
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString2 + "|");
		FileProc.seperateByCommaS(testString2,testList);
		System.out.println("Cleaned string: " + FileProc.insertCommasBetween(testList));
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString3 + "|");
		FileProc.seperateByCommaS(testString3,testList);
		System.out.println("Cleaned string: " + FileProc.insertCommasBetween(testList));
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString4 + "|");
		FileProc.seperateByCommaS(testString4,testList);
		System.out.println("Cleaned string: " + FileProc.insertCommasBetween(testList));
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString5 + "|");
		FileProc.seperateByCommaS(testString5,testList);
		System.out.println("Cleaned string: " + FileProc.insertCommasBetween(testList));
		testList = new ArrayList<String>();
	}

	public static void saveToFileTest()
	{
		Object[] returnLists = FileProc.readFile("fileproctest.txt");
		FileProc.saveToFile("COPYfileproctest.txt",returnLists);

		returnLists = FileProc.readFile("fileproctest2.txt");
		FileProc.saveToFile("COPYfileproctest2.txt",returnLists);

		returnLists = FileProc.readFile("fileproctest3.txt");
		FileProc.saveToFile("COPYfileproctest3.txt",returnLists);

		ArrayList<String> attributeList = new ArrayList<String>();
		attributeList.add("Is this object furry?");
		attributeList.add("Is this object an animal?");
		attributeList.add("Is this object a pet?");
		TreeObject testObject1 = new TreeObject();
		ArrayList<Integer> testArray = new ArrayList<Integer>();
		testArray.add(1);
		testArray.add(2);
		testArray.add(3);
		TreeObject testObject2 = new TreeObject("Object 2", testArray);

		ArrayList<TreeObject> objectList = new ArrayList<TreeObject>();
		objectList.add(testObject1);
		objectList.add(testObject2);

		returnLists = new Object[]{attributeList, objectList};
		FileProc.saveToFile("fileproctest4.txt",returnLists);		
	}

	public static void main(String[] args) 
	{
		fileExistsTest();
		seperateByCommaTest();
		readFileTest();
		insertCommasBetweenTest();
		saveToFileTest();
	}
}