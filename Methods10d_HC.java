import java.awt.Color;


public class Methods10d_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Methods 10b
	 */
	public static void main(String[] args) {
		Ball(1,10,Color.black,0);
		Ball(1,10,Color.red,10);

	}
	public static void Ball(int ball,int BallW,Color c,int d)	{
		Ball b= new Ball();
		b.delay(d);
		for (int i=1; i<100; i++)	{
			b.erase();

			b.move();

			b.draw(c);

			b.delay(100);
		}
		System.exit(0); 
	}

}
