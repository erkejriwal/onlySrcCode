package advancedJavaLynda.multithreading;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		int count = 5;
		try {
			for (int i = 0; i < count; i++) {
				System.out.println("from my runnable "+i);
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
