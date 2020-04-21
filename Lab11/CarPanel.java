import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Draws car shapes
 * 
 * Original author: Unknown
 * 
 * @author Alec M. <this@amattu.com>
 * @date 04/20/2020
 * @version 0.01b
 */
public class CarPanel extends JComponent {
	// Class Variables
	private Car car1;
	private int x,y, delay;
	private CarQueue carQueue;
	private int direction;
	
	CarPanel(int x1, int y1, int d, CarQueue queue) {
		delay = d;
		x = x1;
		y = y1;
		car1 = new Car(x, y, this);
		carQueue = queue;
	}

	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						// Navigate direction
						switch (carQueue.deleteQueue()) {
							case 0: // UP
								y = y <= 10 ? 0 : y-10;
								System.out.println("Received UP command");
								break;
							case 1: // DOWN
								y = y >= 390 ? 400 : y+10;
								System.out.println("Received DOWN command");
								break;
							case 2: // RIGHT
								x = x >= 290 ? 300 : x+10;
								System.out.println("Received RIGHT command");
								break;
							case 3: // LEFT
								x = x <= 10 ? 0 : x-10;
								System.out.println("Received LEFT command");
								break;
						}

						repaint();
						Thread.sleep(delay*1000);
					}
				} catch (InterruptedException e) {
					System.out.println("Something bad happened :( " + e.getMessage());
				}
			}
		}

		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		car1.draw(g2,x,y);
	}
}
