import java.io.Console;
public class UserProc
{
	public static boolean readBinaryInput(String question)
	{
		Console console = System.console();
		String input = console.readLine(question + "(respond with either 'y' or 'n'): ");
		if (input.equals("y") || input.equals("Y") || input.equals("yes") || input.equals("Yes"))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public static String readStringInput (String question)
	{
		Console console = System.console();
		String input = console.readLine(question + ": ") + "";
		return input;	
	}
}