import java.io.Console;
public class UserProc
{
	public static boolean readInput(String question)
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
}