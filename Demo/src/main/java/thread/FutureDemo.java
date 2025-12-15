package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		executorService.execute(() -> System.out.println(Thread.currentThread().getName() + ": Calling notify"));
		Future<Integer> future = executorService.submit(() -> 32);
		System.out.println(future.isDone());
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
		executorService.shutdown();
	}
}
