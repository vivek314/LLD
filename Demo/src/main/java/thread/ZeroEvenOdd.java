package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ZeroEvenOdd {
	private int n;
	private Semaphore evenSemaphore;
	private Semaphore oddSemaphore;
	private Semaphore zeroSemaphore;

	public ZeroEvenOdd(int n) {
		this.n = n;
		evenSemaphore = new Semaphore(0);
		oddSemaphore = new Semaphore(0);
		zeroSemaphore = new Semaphore(1);
	}

	public void zero(){
		boolean isOdd = true;
		for(int i = 0; i < n; i++){
			try {
				zeroSemaphore.acquire();
				System.out.print("0");
				if(isOdd){
					oddSemaphore.release();
				} else{
					evenSemaphore.release();
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			isOdd = !isOdd;
		}
	}

	public void even(){
		for(int i=2;i<=n;i+=2){
			try {
				evenSemaphore.acquire();
				System.out.print(i);
				zeroSemaphore.release();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void odd(){
		for(int i=1;i<=n;i+=2){
			try {
				oddSemaphore.acquire();
				System.out.print(i);
				zeroSemaphore.release();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) {
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(zeroEvenOdd::zero);
		executor.submit(zeroEvenOdd::even);
		executor.submit(zeroEvenOdd::odd);
		executor.shutdown();
	}
}
