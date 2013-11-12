import java.awt.*;

class Ball 
{

	public static final int WIDTH = 20;                        // Ball height, width
	public static final int HEIGHT = 20;

	public int x = 150;                                              // Current x,y
	public int y = 60;

	public int dx = 10;                                               // Distance moved
	public int dy = 10; 

	public Ball()
	{ 
		
		                
	} 

	public void paint(Graphics g) {      
		draw(Color.black,g);
	}

	public void erase(Graphics g) {
		g.setColor(Color.white);                // Erase ball
		g.fillOval(x,y,WIDTH,HEIGHT); 
	}

	public void draw(Color c,Graphics g) {
		g.setColor(c);                   // Draw ball 
		g.fillOval(x,y,WIDTH,HEIGHT);
	}

	public void delay(int t)
	{
		try { Thread.sleep(t); } catch(Exception e) {}
	}
	public void move() {  
		x = x + dx; 											 // Move x
		y = y + dy;                                            // Move y

		if (x < 0) {                                            // Hit left wall
			x = 0; 
			dx = -dx; 
		}                  
/**
		if (x + WIDTH >= getWidth()) {               // Hit right wall
			x = getWidth() - WIDTH;             
			dx = -dx;
		} 
		if (y < 25) {                                            // Hit top wall
			y = 25; 
			dy = -dy; 
		}                                                           
		if (y + HEIGHT >= getHeight()) {             // Hit bottom wall
			y = getHeight() - HEIGHT; 
			dy = -dy; 
		}   **/
	}
}

