package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class BarrierSynchronization {
	private static final Semaphore mutex = new Semaphore(1);
	private static final Semaphore barrier = new Semaphore(0);

	static class Barrier{
		private int count;
		private final int parties;
		public Barrier(int numOfThreads){
			this.count = numOfThreads;
			this.parties = numOfThreads;
		}

		public void await(){
			try {
				mutex.acquire();
				System.out.println("Acquired the lock: " + Thread.currentThread().getName());
				count--;
				if(count == 0){
					System.out.println("Barrier has been acquired and releasing all the threads");
					barrier.release(parties-1);
					mutex.release();
				} else{
					System.out.println(Thread.currentThread().getName() + " is trying to release the lock");
					mutex.release();
					barrier.acquire();
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		Barrier barrier = new Barrier(5);
		for(int i = 0; i < 5; i++){
			executor.submit(() -> {
				try {
					System.out.println(Thread.currentThread().getName() + " is doing phase 1 work");
					Thread.sleep((long) (Math.random()%10 * 1000));
					System.out.println(Thread.currentThread().getName() + " arrived at barrier after phase 1");
					barrier.await();

					System.out.println(Thread.currentThread().getName() + " is doing phase 2 work");
					Thread.sleep((long) (Math.random()%10 * 1000));
					System.out.println(Thread.currentThread().getName() + " arrived at barrier after phase 2");
					barrier.await();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			});
		}
	}

}
