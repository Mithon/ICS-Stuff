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

		Ball(g, Color.LIGHT_GRAY, Color.GRAY, f, 150, 60, 500, 60);
	}
	public static void Ball(Graphics g, Color c, Color c2, Frame f,int x, int y,int x2, int y2)        {
		Ball b = new Ball();
		Ball a = new Ball();
		b.startLOC(x,y);
		a.startLOC(x2,y2);
		double d = 100;
		for (int i=1; i<200; i++)        {
			move(g,c,f,b);
			move(g,c2,f,a);
			d = Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
			if (d<50)	{
				a.dx = -a.dx;
				a.dy = -a.dy;
				b.dx = -b.dx;
				b.dy = -b.dy;
			}	
		}
		System.exit(0); 
	}
	public static void move(Graphics g, Color c, Frame f, Ball b)	{
		b.erase(g);

		b.move(f);

		b.draw(c,g);

		b.delay(30);
	}


}
