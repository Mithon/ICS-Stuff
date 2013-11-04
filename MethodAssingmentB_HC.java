import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class MethodAssingmentB_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Methods 10b
	 */
	public static void main(String[] args) {
		randomNumber();
		System.out.println(gcd(36,15));
	}
	//1. a)
	public static int randomNumber ()	{
		Random R = new Random();
		int num = R.nextInt((6 - 1) + 1) + 1;
		return num;
	}
	//1. b)
	public static int randomNumber (int high)	{
		Random R = new Random();
		int num = R.nextInt((high - 1) + 1) + 1;
		return num;
	}
	//1. c)
	public static int randomNumber (int min, int max)	{
		Random R = new Random();
		int num = R.nextInt((max - min) + 1) + 1;
		return num;
	}
	//1. d)
	public static int randomNumber (int min, int max, int step)	{
		int num = 9999;
		while (num%step != 0)	{
			Random R = new Random();
			num = R.nextInt((max - min) + 1) + 1;
		}
		return num;
	}
	//#2
	//a) mystery
	//b) two doubles. double a and double b.
	//c) it returns an integer
	//d) below
	public static int mystery (double a, double b)
	{
		int value = 0;
		if (a < b)
		{
			value = -1;
		}
		else if (a > b)
		{
			value = 1;
		}
		return value;
	}
	//e) below
	public static int mystery2 (double a, double b)
	{
		int value = 0;
		if (a < b)
		{
			return -1;
		}
		if (a > b)
		{
			return 1;
		}
		else
			return 0;
	}
	//#3
	// C and D are incorrect
	// C would not work because you cant print in the same line as a variable is being assigned
	// D does not work because you can't have two semicolons and things assigned to one variable
	//#4 below
	public static double largest (double a, double b, double c)
	{
		return Collections.max(Arrays.asList(a, b, c));
	}
	//#5 below
	public static int gcd (int x, int y)	{
		int max = Collections.max(Arrays.asList(x, y));
		int min = Collections.min(Arrays.asList(x, y));
		int a = max%min;
		int b = min%a;
		while (b !=0)	{
			b = gcd(a, b);
		}
		return a;
	}
	//#6
	
}
