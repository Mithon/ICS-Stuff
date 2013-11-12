import java.awt.*;


public class Methods10d_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Methods 10b
	 */
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(300,300);                         
		f.setVisible(true); 
		f.setBackground(Color.white);
		Graphics g = f.getGraphics();
		
		Ball(g,1,10,Color.LIGHT_GRAY,0);
		Ball(g,1,10,Color.BLUE,30);
	}
	public static void Ball(Graphics g, int ball,int BallW,Color c,int d)	{
		Ball b= new Ball();
		b.delay(d);
		for (int i=1; i<300; i++)	{

			b.erase(g);

			b.move();

			b.draw(c,g);

			b.delay(50);
		}
		System.exit(0); 
	}

}
