import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class File_Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
		throws FileNotFoundException {
		Scanner input = new Scanner(new File("Results.txt"));
		PrintStream out = new PrintStream(new File("Output.txt"));
		char[] master = input.nextLine().toCharArray();
		ArrayList<String> marks = new ArrayList<String>();
		while (input.hasNextLine())	{
			mark.add(adder(input.nextLine,(input.nextLine.toCharArray())));
		}
	}
	public static String adder (String name, char[] ans)	{
		return name;
	}

}
