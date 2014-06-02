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
		FileProc.seperateByComma(testString1,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString2 + "|");
		FileProc.seperateByComma(testString2,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString3 + "|");
		FileProc.seperateByComma(testString3,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString4 + "|");
		FileProc.seperateByComma(testString4,testList);
		System.out.println(testList);
		testList = new ArrayList<String>();

		System.out.println("Testing the string in brackets: |" + testString5 + "|");
		FileProc.seperateByComma(testString5,testList);
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
	}

	public static void main(String[] args) 
	{
		//fileExistsTest();
		//seperateByCommaTest();
		readFileTest();
	}
}