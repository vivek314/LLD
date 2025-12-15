package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
	private String logValue = "intial";
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void write(String newValue){
		try{
			lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + ": acquired write lock");
			logValue = newValue;
			System.out.println(Thread.currentThread().getName() + ": Changed value to new value: "+ logValue);
		} finally {
			lock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + ": released write lock");
		}
	}

	public void read(){
		try{
			lock.readLock().lock();
			System.out.println(Thread.currentThread().getName() + ": acquired read lock");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + ": Read the value as: " + logValue);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.readLock().unlock();
		}
	}

	public static void main(String[] args) {
		ReadWriteLockExample example = new ReadWriteLockExample();
		ExecutorService executor = Executors.newFixedThreadPool(8);

		executor.execute(example::read);
		executor.execute(example::read);
		executor.execute(example::read);

		executor.execute(() -> example.write("a"));

		executor.execute(() -> example.write("b"));

		executor.execute(example::read);

		executor.shutdown();
	}
}
