import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;

public class FileProc
{

	public static boolean fileExists(String filename)
	{
		return new File(filename).exists();
	}

	public static void seperateByCommaS(String stringToBreak, ArrayList<String> arrayListToModify)
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
	public static void seperateByCommaI(String stringToBreak, ArrayList<Integer> arrayListToModify)
	{
		for (int i = 0; i < stringToBreak.length(); i++)
		{
			//System.out.println("i: " + i + stringToBreak.substring(i));
			int indexOfComma = stringToBreak.indexOf(",",i);
			//System.out.println("i: " + i + " commaI: " + indexOfComma);
			if (indexOfComma > 0)
			{
			    arrayListToModify.add(Integer.parseInt(stringToBreak.substring(i,indexOfComma)));
				i = indexOfComma;
			}
			else
			{
				arrayListToModify.add(Integer.parseInt(stringToBreak.substring(i)));
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
				seperateByCommaS(firstString,(ArrayList)returnValue[0]);
				//Process the objects and their attributes
				while (fileScan.hasNext())
				{
					ArrayList<Integer> attrList = new ArrayList<Integer>();
					String objectName = fileScan.nextLine();
					String attrString = fileScan.nextLine();
					seperateByCommaI(attrString, attrList);
					((ArrayList)returnValue[1]).add(new TreeObject(objectName, (ArrayList<Integer>) attrList));		
				}
				}
			catch (Exception e)
			{
				//We need to think of a way to handle exceptions
			}
			return returnValue;
		}			
		else
		{
			return new Object[]{null, null};
		}
	}

	public static String insertCommasBetween(ArrayList arrayListToRead)
	{
		String returnString = "";
		for (int i = 0; i < arrayListToRead.size();i++)
		{
			if (i == arrayListToRead.size()-1)
			{
				returnString += "" + arrayListToRead.get(i);
			}
			else
			{
				returnString += "" + arrayListToRead.get(i) + ",";
			}
		}
		return returnString;
	}

	//this function produces a file that can later be read to create the lists that are stored in it
	public static void saveToFile(String filename, Object[] listsToSave)
	{
		try
		{
			File fileToWrite = new File(filename);
			PrintWriter fileWriter = new PrintWriter(fileToWrite);
			ArrayList<String> attributeList = (ArrayList<String>) listsToSave[0];
			ArrayList<TreeObject> objectList = (ArrayList<TreeObject>) listsToSave[1];
			//Write the attributes to the file
			fileWriter.println(insertCommasBetween(attributeList));
			//Write the objects to the file
			TreeObject objectToWrite;
			for (int i = 0; i < objectList.size(); i++)
			{
				objectToWrite = objectList.get(i);
				fileWriter.println((String)objectToWrite.getName());
				fileWriter.println(insertCommasBetween((ArrayList)objectToWrite.getAttributes()));
			}
			fileWriter.close();

		}
		catch (Exception e)
		{
			//We need to think of a way to handle exceptions
		}

	}
}