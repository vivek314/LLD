package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
	private final int taskId;
	public WorkerThread(int taskId){
		this.taskId = taskId;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": is processing task: "+ taskId);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println(Thread.currentThread().getName() + ": finished task: "+ taskId);
	}
}

public class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			executorService.execute(new WorkerThread(i));
		}
		executorService.shutdown();
	}
}
