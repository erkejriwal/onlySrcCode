package javatpoint.threadExample;

public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 thread1 = new Thread1();
		Thread t1 = new Thread(thread1);
		t1.start();
		Thread t2 = new Thread(thread1);
		t2.start();
	}

}

class Thread1 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			System.out.println("Thread1");
			
		}
	}
	
}


