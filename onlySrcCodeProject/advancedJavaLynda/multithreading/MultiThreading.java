package advancedJavaLynda.multithreading;

public class MultiThreading {
	
	public void multiThreadingExample(){
		ThreadObject threadObject = new ThreadObject();
		MyThread myThread1 = new MyThread(1,threadObject);
		myThread1.start();
		
		MyThread myThread2 = new MyThread(2,threadObject);
		myThread2.start();
		
		MyThread myThread3 = new MyThread(3,threadObject);
		myThread3.start();
		
		MyRunnable myRunnable = new MyRunnable();
		new Thread(myRunnable).start();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("just to call interrupt mythread");
		myThread1.interrupt();
		System.out.println("called interrupt mythread");

		int count = 3;
		try {
			for (int i = 0; i < count; i++) {
				System.out.println("from main thread "+i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
