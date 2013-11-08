import java.awt.*;

class Ball extends Frame
{
   Graphics graphics=null;

   static final int WIDTH = 20;                        // Ball height, width
   static final int HEIGHT = 20;

   int x = 150;                                              // Current x,y
   int y = 60;
                      
   int dx = 10;                                               // Distance moved
   int dy = 10; 

   public Ball()
   { 
      setSize(300,300);                                  // Size
      setVisible(true); 
      setBackground(Color.white);                     // Color
      graphics = getGraphics();                       // Frame reference
   } 

   public void paint(Graphics graphics) {      
       draw(Color.black);
   }
    
   public void erase() {
      graphics.setColor(Color.white);                // Erase ball
      graphics.fillOval(x,y,WIDTH,HEIGHT); 
   }

   public void draw(Color c) {
      graphics.setColor(c);                   // Draw ball 
      graphics.fillOval(x,y,WIDTH,HEIGHT);
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
      }   
   }
}
