import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	Queue<Integer> queue;
	Random direction;
	
	public CarQueue()  {
		queue = new ArrayDeque<Integer>();
		direction = new Random();
		
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
		queue.add(direction.nextInt(4));
	}
	
	public Integer deleteQueue() {
		return queue.remove();
	}
	
	public void addToQueue() {
		class QueueRunnable implements Runnable {
			/**
			 * Adds 0, 1, 2, or 3 to queue
			 * 0 = up
			 * 1 = down
			 * 2 = right
			 * 3 = left
			 */
			public void run()
			{
				try {
					while (true) {
						queue.add(direction.nextInt(4));
						Thread.sleep(20);
						
					}
				}
				catch (InterruptedException exception) {
					
				}
				finally {
					
				}
			}
		}
		Runnable r = new QueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}
