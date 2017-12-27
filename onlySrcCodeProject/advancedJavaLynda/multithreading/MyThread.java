package onlySrcCode.onlySrcCodeProject.advancedJavaLynda.multithreading;

public class MyThread extends Thread {
	private int threadId;
	private ThreadObject obj;

	// public MyThread() {
	// // TODO Auto-generated constructor stub
	// }

	public MyThread(int threadId, ThreadObject obj) {
		this.threadId = threadId;
		this.obj = obj;
	}

	@Override
	public void run() {
		int count = 5;
		synchronized (obj) {
			try {
				for (int i = 0; i < count; i++) {
					sleep(2000);
					// System.out.println("from my thread "+i);
					obj.call(threadId);
				}
			} catch (InterruptedException e) {
				System.out.println("MyThread interrupted......");
			}
		}
	}

}
