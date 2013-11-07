import java.awt.Color;
import java.awt.Graphics;


public class Methods10c_HC {

	/**
	 * @author Hunter and Martin
	 * Mr.Marco
	 * Methods 10c
	 */
	public static void main(String[] args) {
		//Exercise 1
		int a = 15;
		sentence(a, 42);      //outputs 15 42

		int b = a - 7;
		sentence(b, a + b);   //outputs 8 23

		//Exercise 2
		String soda = "coke";
		String pop = "pepsi";
		String coke = "pop";
		String pepsi = "soda";
		String say = pop;

		carbonated(coke, soda, pop);         //  say coke not pepsi or pop
		carbonated(pop, pepsi, pepsi);       //  say soda not soda or pepsi
		carbonated("pop", pop, "koolaid");   //  say pepsi not koolaid or pop
		carbonated(say, "say", pop);  		 //	say say not pepsi or pepsi

		//Exercise 3
		double bubble = 867.5309;
		double x = 10.01;
		double y = 0; //not sure what the use of y is but it needed to be declared
		printer(x, y, bubble); //no need to declare things on this line //y was not assigned yet
		//printer(x); Im assusing this was useless so I commented it out
		//printer("barack", "obama"); obama is not a double, sorry. I made it so the method prints obama instead
		//z was printed up here but I put in in the printer method instead

		//Exercise 4: Conversion
		System.out.println(inchTOcm(6) + "cm");
		System.out.println(feetTOmetres(10) + "m");
		System.out.println(milesTOkm(20) + "km");

		//Exercise 4: Strings
		printStrings("Hunter", 5);

		//Exercise 5
		manyfaces(12); //parameter is # of faces printed

		//Exercise 6
		simpleStairs(1); //choose from 1-4
	}


	public static void sentence(int num1, int num2) {
		System.out.println(num1 + " " + num2);
	}
	public static void carbonated(String coke, String soda, String pop) {
		System.out.println("say " + soda + " not " + pop + " or " + coke);
	}
	public static void printer(double x, double y, double bubble) { //double declaration was in the wrong place //x was  not declared
		int z = 5;
		System.out.println("x = " + x + " and y = " + y); //x should be declared in the parameters instead of here
		System.out.println("The value from main is: " + bubble);
		System.out.println("z = " + z);
		System.out.println("barack obama");
	}
	public static double inchTOcm(double x)	{
		return 2.54*x;
	}
	public static double feetTOmetres(double x)	{
		return 0.3048*x;
	}
	public static double milesTOkm(double x)	{
		return 1.60934*x;
	}
	public static void printStrings(String x, int y)	{
		for(int i=1; i<=5; i++)
			System.out.print(x + " ");
	}
	public static void manyfaces(int x)	{
		DrawingPanel panel = new DrawingPanel(25+100*x, 150);
		Graphics g = panel.getGraphics();

		for(int i=1; i<=x; i++)	{
			g.setColor(Color.BLACK);
			g.drawOval(i*100-90, 30, 100, 100);   // face outline
			g.setColor(Color.BLUE);
			g.fillOval(i*100-70, 60, 20, 20);     // eyes
			g.fillOval(i*100-30, 60, 20, 20);
			g.setColor(Color.RED);          // mouth
			g.drawLine(i*100-20, 100, i*100-60, 100);
		}
	}
	public static void stairs(int x, int y, int width, int height, boolean updown, boolean leftright)	{
		DrawingPanel panel = new DrawingPanel(120, 110);
		Graphics g = panel.getGraphics();
		if (updown == true && leftright == true)	{
			for (int i = 0; i < 10; i++) {
				g.drawRect(x, y, width, height);
				y = y + 10;           // move down and widen by 10
				width = width + 10;
			}
		}
		if (updown == false && leftright == true)	{
			for (int i = 0; i < 10; i++) {
				g.drawRect(x, y, width, height);
				y = y + 10;           // move down and widen by 10
				width = width - 10;
			}
		}
		if (updown == true && leftright == false)	{
			for (int i = 0; i < 10; i++) {
				g.drawRect(x, y, width, height);
				x = x - 10;
				y = y + 10;           // move down and widen by 10
				width = width + 10;
			}
		}
		if (updown == false && leftright == false)	{
			for (int i = 0; i < 10; i++) {
				g.drawRect(x, y, width, height);
				x = x + 10;
				y = y + 10;           // move down and widen by 10
				width = width - 10;
			}
		}
	}
	public static void simpleStairs(int direction)	{
	if (direction == 1)
		stairs(5,5,10,10, true, true);
	if (direction == 2)
		stairs(5,5,100,10, false, true);
	if (direction == 3)
		stairs(100,5,10,10, true, false);
	if (direction == 4)
		stairs(10,5,100,10, false, false);
	}
}
