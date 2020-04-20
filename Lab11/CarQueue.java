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
			this.queue.add(this.random.nextInt());
		}
	}
	
	/**
	 * 
	 */
	public void addToQueue() {
		protected java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
		protected java.util.Random random = new java.util.Random();
		
		// 
		class Ops implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 4; i++) {
					super.queue.add(this.random.nextInt());
				}
			}
		}
		
	}

	/**
	 * Generate Next Task
	 * 
	 * @param None
	 * @return Int Task (0: Up, 1: Down, 2: Right, 3: Left)
	 * @throws None
	 */
	public int deleteQueue() {
		return this.queue.isEmpty() == false ? this.queue.remove() : 0;
	}
}
