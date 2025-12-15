package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedDemo {

	private int count = 0;
	private final Object lock = new Object();
	public void add(){
		System.out.println(Thread.currentThread().getName() + ": PreProcessing");
		synchronized (lock){
			System.out.println(Thread.currentThread().getName() + ": Starting Add");
			count++;
			System.out.println(Thread.currentThread().getName() + ": After adding " + count);
			System.out.println(Thread.currentThread().getName() + ": Ending Add");
		}
	}
	public int getCount(){
		return count;
	}
	public static void main(String[] args) {
		SynchronizedDemo demo = new SynchronizedDemo();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 5; i++){
			executorService.execute(() -> demo.add());
		}
		executorService.shutdown();
	}
}
