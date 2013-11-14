import java.awt.*;

class Ball 
{
        public static final int WIDTH = 50;                        // Ball height, width
        public static final int HEIGHT = 50;

        public int x = 150;                                              // Current x,y
        public int y = 60;


        public int dx = 10;                                               // Distance moved
        public int dy = 10; 

        public Ball()
        { 

        } 

        public void startLOC(int a, int b)
        {
                x = a;
                y = b;
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
        public void move(Frame f) {
                x = x + dx;                                                                                          // Move x
                y = y + dy;                                            // Move y

                if (x < 0) {                                            // Hit left wall
                        x = 0; 
                        dx = -dx; 
                        Toolkit.getDefaultToolkit().beep();
                }                  

                if (x + WIDTH >= f.getWidth()) {               // Hit right wall
                        x = f.getWidth() - WIDTH;             
                        dx = -dx;
                        Toolkit.getDefaultToolkit().beep();
                } 
                if (y < 25) {                                            // Hit top wall
                        y = 25; 
                        dy = -dy; 
                        Toolkit.getDefaultToolkit().beep();
                }                                                           
                if (y + HEIGHT >= f.getHeight()) {             // Hit bottom wall
                        y = f.getHeight() - HEIGHT; 
                        dy = -dy;
                        Toolkit.getDefaultToolkit().beep();
                }
        }
}
