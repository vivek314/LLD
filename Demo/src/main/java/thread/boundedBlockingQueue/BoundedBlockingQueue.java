package thread.boundedBlockingQueue;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {
	private Semaphore full;
	private Semaphore empty;

	private ConcurrentLinkedDeque<Integer> queue;

	public BoundedBlockingQueue(int capacity) {
		this.full = new Semaphore(0);
		this.empty = new Semaphore(capacity);
		this.queue = new ConcurrentLinkedDeque<>();
	}

	public void enqueue(int item) {
		try {
			empty.acquire();
			queue.addFirst(item);
			full.release();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public int dequeue() {
		int result = 1;
		try{
			full.acquire();
			result= queue.pollLast();
			empty.release();
			return result;
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}

}
