
public class Q27 {
	static int howManyCounts = 0;
	public static void main(String[] args) {
		class OutputThread extends Thread {
			String pre = "";
			int max = 0;
			
			public OutputThread(String pre, int max) {
				this.pre = pre;
				this.max = max;
			}
			
			public void run() {
				for (int i = 0; i < this.max; i++) {
					System.out.println(this.pre + count());
				}
			}
		}
		
		OutputThread th1 = new OutputThread("One ", 3);
		OutputThread th2 = new OutputThread("Two ", 3);
		th1.start();
		th2.start();
		
		/*
		for (int i = 0; i < 3; i++) {
			System.out.println("One" + count());
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("Two" + count());
		}
		*/
	}
	public static int count() {
		return howManyCounts++;
	}

}
