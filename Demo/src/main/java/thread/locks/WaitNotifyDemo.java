package thread.locks;

public class WaitNotifyDemo {
	private final Object lock = new Object();
	private Boolean conditionMet = false;

	public void doWait(){
		synchronized (lock){
			System.out.println(Thread.currentThread().getName() + ": is Waiting");
			while(!conditionMet){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println(Thread.currentThread().getName() + ": resumed execution");
		}
	}

	public void doNotifyAll(){
		synchronized (lock){
			System.out.println(Thread.currentThread().getName() + ": Calling notifyAll");
			conditionMet = true;
			lock.notifyAll();
		}
	}

	public static void main(String[] args) {
		WaitNotifyDemo demo = new WaitNotifyDemo();
		Thread t1 = new Thread(() -> demo.doWait(), "Waiter-1");
		Thread t2 = new Thread(() -> demo.doWait(), "Waiter-2");
		Thread t3 = new Thread(() -> demo.doWait(), "Waiter-3");
		t1.start();
		t2.start();
		t3.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Thread notifer = new Thread(() -> demo.doNotifyAll(), "Notifier");
		notifer.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			notifer.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
