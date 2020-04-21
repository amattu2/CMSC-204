/**
 * A car direction randomizer 
 * 
 * @author Alec M.
 * @date 04/20/2020
 * @version 0.01a
 * @see Thread Lab.docx
 */
public class CarQueue {
	// Class Variables
	protected java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
	protected java.util.Random random = new java.util.Random();
	
	/**
	 * Class Constructor
	 * 
	 * @param None
	 * @return None
	 * @throws None
	 */
	public CarQueue() {
		// Loops
		for (int i = 0; i < 6; i++) {
			this.queue.add(this.random.nextInt(4));
		}
	}
	
	/**
	 * Add More Directions To Queue
	 * 
	 * @param None
	 * @return None
	 * @throws None
	 */
	public void addToQueue() {
		// Private Thread Class
		class Runner implements Runnable {
			@Override
			public void run() {
				// Add items
				for (int i = 0; i < 6; i++) {
					// Add to queue
					queue.add(random.nextInt(4));
				}
				
				// Pause next item
				try {
					Thread.sleep(1000);
				} catch(Exception e) {};				
			}
		}
		
		// Variables
		Runner r = new Runner();
		Thread t = new Thread(r);
		
		// Start
		t.start();
	}

	/**
	 * Generate Next Task
	 * 
	 * @param None
	 * @return Int Task (0: Up, 1: Down, 2: Right, 3: Left)
	 * @throws None
	 */
	public int deleteQueue() {
		// Checks
		if (this.queue.isEmpty()) // Queue is empty, add items
			this.addToQueue();
		
		return this.queue.isEmpty() == false ? this.queue.remove() : 0;
	}
}
