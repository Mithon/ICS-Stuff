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
	System.out.println(randomNumber());
	System.out.println(randomNumber(10));
	System.out.println(randomNumber(1, 10));
	System.out.println(randomNumber(5, 50, 5));
	System.out.println(mystery(1, 10));
	System.out.println(mystery2(1, 10));
	System.out.println(largest(1, 10, 60));
	System.out.println(gcd(30, 90));
	System.out.println(isDivisible(14, 7));
	System.out.println(isPrime(11));
	System.out.println(isLetter('|'));
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
		return INNERgcd(max, min);
	}
	public static int INNERgcd (int a, int b)	{
		while(b > 0)
		{
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	//#6
	public static boolean isDivisible (int a, int b)	{
		if (a%b == 0)
			return true;
		else
			return false;
	}
	//#7
	public static boolean isPrime (int a)	{
		for (int i=2; i<a; i++)	{
			if (a%i == 0)
				return false;
		}
		return true;
	}
	//#8
	public static boolean isLetter (char a)	{
		if (Character.isLetter(a))
			return true;
		else
			return false;
	}
}
