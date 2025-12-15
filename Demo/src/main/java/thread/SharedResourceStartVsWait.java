package thread;

class SharedResource {
	public synchronized void waitExample() {
		System.out.println(Thread.currentThread().getName() + ": Entering wait example");
		try {
			System.out.println(Thread.currentThread().getName() + ": Calling wait");
			wait();
			System.out.println(Thread.currentThread().getName() + ": Resumed after notify");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public synchronized void resumeExample() {
		System.out.println(Thread.currentThread().getName() + ": Calling notify");
		notify();
	}
}

public class SharedResourceStartVsWait{
	public static void main(String[] args) {
		SharedResource sr = new SharedResource();
		Thread t1 = new Thread(() -> sr.waitExample(), "Thread-1");
		Thread t2 = new Thread(() -> sr.waitExample(), "Thread-2");

		Thread notifier = new Thread(() -> {
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sr.resumeExample();
			try{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sr.resumeExample();
		}, "Notifier");
		t1.start();
		t2.start();
		notifier.start();
	}
}
