import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FileProc
{

	public static boolean fileExists(String filename)
	{
		return new File(filename).exists();
	}

	public static void seperateByComma(String stringToBreak, ArrayList arrayListToModify)
	{
		for (int i = 0; i < stringToBreak.length(); i++)
		{
			//System.out.println("i: " + i + stringToBreak.substring(i));
			int indexOfComma = stringToBreak.indexOf(",",i);
			//System.out.println("i: " + i + " commaI: " + indexOfComma);
			if (indexOfComma > 0)
			{
				arrayListToModify.add(stringToBreak.substring(i,indexOfComma));
				i = indexOfComma;
			}
			else
			{
				arrayListToModify.add(stringToBreak.substring(i));
				break;
			}
		}
	}

	//The readFile method reads a file and outputs an array that has two two values: 
	//the first is an arraylist containing the names of the attributes and the second is an arraylist containing the treeobjects
	public static Object[] readFile(String filename)
	{
		Object[] returnValue = new Object[]{new ArrayList<String>(), new ArrayList<TreeObject>()};
		File fileToRead = new File(filename);
		if (fileToRead.exists() && (fileToRead.length() > 0))
		{
			try
			{
				Scanner fileScan = new Scanner(fileToRead);
				// Process the attribute names
				String firstString = fileScan.nextLine();
				seperateByComma(firstString,(ArrayList)returnValue[0]);
				//Process the objects and their attributes
				while (fileScan.hasNext())
				{
					ArrayList<Integer> attrList = new ArrayList<Integer>();
					String objectName = fileScan.nextLine();
					String attrString = fileScan.nextLine();
					seperateByComma(attrString, attrList);
					((ArrayList)returnValue[1]).add(new TreeObject(objectName, attrList));		
				}
				}
			catch (Exception ex)
			{

			}
			return returnValue;
		}			
		else
		{
			return new Object[]{null, null};
		}
	}
}