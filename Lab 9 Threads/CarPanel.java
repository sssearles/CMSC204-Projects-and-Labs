import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CarPanel extends JComponent
{  
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue)
	{
		delay = d;
        x=x1;
        y=y1;
        car1 = new Car(x, y, this);
        carQueue = queue;
	}
	public void startAnimation()
	   {
	      class AnimationRunnable implements Runnable
	      {
	         public void run()
	         {
	            try
	            {
	               for(int i=0;i<100;i++)
	               {
	            	   int deltax = 10, deltay = 10;
	            	   
	            	   direction = carQueue.deleteQueue();
	            	   int tempy = y;
	            	   int tempx = x;
	            	   deltax = deltay = 10;
	            	   switch(direction) {
	            	   
	            	   case 0: tempy = tempy - deltay;
	            	   		break;
	            	   case 1: tempy = tempy + deltay;
	            	   		break;
	            	   case 2: tempx = tempx + deltax;
	            	   		break;
	            	   case 3: tempx = tempx - deltax;
	            	   }
	            	   if(tempx < 0) {
	            		   x = 10; 
	            	   }
	            	   else if (tempx > 300) {
	            		   x = 290;
	            	   }
	            	   else if (tempy <0) {
	            		   y = 10;
	            	   }
	            	   else if (tempy > 400) {
	            		   y = 390;
	            	   }
	            	   else {
	            	   x = tempx;
	            	   y = tempy;
	            	   }
	            	   repaint();
	            	   Thread.sleep(delay*100);
	            	   
	               }
	            }
	            catch (InterruptedException exception)
	            {
	            	
	            }
	            finally
	            {
	            	
	            }
	         }
	      }
	      
	      Runnable r = new AnimationRunnable();
	      Thread t = new Thread(r);
	      t.start();
	   }
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      car1.draw(g2,x,y);    
   }
}