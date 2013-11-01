import java.util.Random;


public class MethodAssingmentB_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Methods 10b
	 */
	public static void main(String[] args) {
		randomNumber();
	}
	public static int randomNumber ()	{
		Random R = new Random();
		int num = R.nextInt((6 - 1) + 1) + 1;
		return num;
	}
	public static int randomNumber (int high)	{
		Random R = new Random();
		int num = R.nextInt((high - 1) + 1) + 1;
		return num;
	}
	public static int randomNumber (int min, int max)	{
		Random R = new Random();
		int num = R.nextInt((max - min) + 1) + 1;
		return num;
	}
	public static int randomNumber (int min, int max, int step)	{
		Random R = new Random();
		int num = R.nextInt(((max - min) + 2)/5) + 1;
		return num;
	}
}
