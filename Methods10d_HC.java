import java.awt.*;


public class Methods10d_HC {

	/**
	 * @author Hunter Caron
	 * Mr.Marco
	 * Methods 10b
	 */
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(500,500);                         
		f.setVisible(true); 
		f.setBackground(Color.white);
		Graphics g = f.getGraphics();

		Ball(g, Color.LIGHT_GRAY, Color.GRAY, f, 150, 60, 200, 500);
	}
	public static void Ball(Graphics g, Color c, Color c2, Frame f,int x, int y,int x2, int y2)        {
		Ball b = new Ball();
		Ball a = new Ball();
		b.startLOC(x,y);
		a.startLOC(x2,y2);
		double d = 100;
		int r1;
		for (int i=1; i<1000; i++)        {
			r1 = 1 + (int)(Math.random() * ((2 - 1) + 1));
			move(g,c,f,b);
			move(g,c2,f,a);
			d = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
			if (d<60)	{
				a.dx = -a.dx+r1;
				a.dy = -a.dy+r1;
				b.dx = -b.dx+r1;
				b.dy = -b.dy+r1;
			}	
		}
		System.exit(0); 
	}
	public static void move(Graphics g, Color c, Frame f, Ball b)	{
		b.erase(g);

		b.move(f);

		b.draw(c,g);

		b.delay(20);
	}


}
