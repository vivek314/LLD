package thread.semaphores;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {

	private static void accessCS(String threadName){
		System.out.println(threadName + " Is attempting to acquire the lock");
		try {
			mutex.acquire();
			System.out.println(threadName + " acquired the lock");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println(threadName + " released the lock");
			mutex.release();
		}
	}

	private static final Semaphore mutex = new Semaphore(1);
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> accessCS("t1"));
		Thread t2 = new Thread(() -> accessCS("t2"));
		t1.start();
		t2.start();
	}
}
