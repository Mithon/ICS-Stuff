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
		Ball b = new Ball();
		Ball c = new Ball();
		
		
		Ball(g,b,Color.LIGHT_GRAY,0,f, 150, 60);
		Ball(g,c,Color.BLUE,100,f, 0, 0);
	}
	public static void Ball(Graphics g, Ball b, Color c,int d,Frame f,int x, int y)	{
		b.delay(d);
		b.startLOC(x,y);
		for (int i=1; i<300; i++)	{

			b.erase(g);

			b.move(f);

			b.draw(c,g);

			b.delay(50);
		}
		System.exit(0); 
	}

}
