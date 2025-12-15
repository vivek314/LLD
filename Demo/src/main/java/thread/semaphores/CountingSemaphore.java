package thread.semaphores;

import java.util.concurrent.Semaphore;

public class CountingSemaphore {
	private static final Semaphore resourcePool = new Semaphore(3);

	private static void fun(String threadName){
		try {
			System.out.println(threadName + " is trying to acquire the lock");
			resourcePool.acquire();
			System.out.println(threadName + " is acquired the lock");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println(threadName + " is releasing the lock");
			resourcePool.release();
		}

	}

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			String finalI = "Thread" + i;
			Thread t = new Thread(() -> fun(finalI));
			t.start();
		}
	}
}
