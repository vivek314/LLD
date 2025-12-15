package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	private int counter = 0;
	private final ReentrantLock lock = new ReentrantLock();
	public void increaseCounter() {
		try{
			lock.lock();
			System.out.println(Thread.currentThread().getName() + ": increasing counter");
			counter++;
			System.out.println(Thread.currentThread().getName() + ": increased counter to " + counter);
		} finally {
			System.out.println(Thread.currentThread().getName() + ": releasing lock");
			lock.unlock();
		}
	}
	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		ReentrantLockExample example = new ReentrantLockExample();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++) {
			executor.execute(example::increaseCounter);
		}
		executor.shutdown();
	}
}
