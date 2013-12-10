import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class twelve_A_HC {

	/**
	 * @author Hunter Caron
	 * ICS 3U1
	 * Mr.Marco
	 */
	public static void main(String[] args) 
			throws FileNotFoundException {
		Scanner input = new Scanner(new File("Results.txt"));
		PrintStream out = new PrintStream(new File("Output.txt"));
		char[] master = input.nextLine().toCharArray();
		ArrayList<String> marks = new ArrayList<String>();
		while (input.hasNextLine())	{
			marks.add(adder(input.nextLine(),input.nextLine().toCharArray(), master));
		}
		for (int i = 0; i < marks.size(); i++)
			out.println(marks.get(i));
	}
	public static String adder (String name, char[] ans, char[] master)	{
		int correct = 0;
		for (int y = 0; y < 10; y++)        {
			if (Arrays.asList(master[y]).contains(ans[y]))
				correct++;
		}
		return name + "\t\t" + correct + "0%";
	}

}
