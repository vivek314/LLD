package thread.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	private final Queue<Integer> buffer = new LinkedList<>();
	private final int capacity = 5;

	void produce() throws InterruptedException {
		int value = 0;
		while(true){
			synchronized (this) {
				while(buffer.size() == capacity){
					System.out.println(Thread.currentThread().getName() + ": Buffer full, producer is waiting");
					wait();
				}
				System.out.println("Producer produced: " + value);
				buffer.offer(value++);
				notifyAll();
			}
			Thread.sleep(1000);
		}
	}

	void consume() throws InterruptedException {
		while(true){
			synchronized (this) {
				while(buffer.isEmpty()){
					System.out.println(Thread.currentThread().getName() + ": Buffer empty, consumer is waiting");
					wait();
				}
				System.out.println("Consumer consumed: " + buffer.poll());
				notifyAll();
			}
			Thread.sleep(500);
		}
	}

	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		Thread producerThread = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}, "ProducerThread");
		Thread consumerThread = new Thread(() -> {
			try{
				pc.consume();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}, "ConsumerThread");

		producerThread.start();
		consumerThread.start();
	}
}
