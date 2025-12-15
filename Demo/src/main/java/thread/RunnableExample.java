package thread;

class MyRunnbale implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i + "is running");
			try{
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

public class RunnableExample {
	public static void main(String[] args) {
		MyRunnbale myrunnbale = new  MyRunnbale();
		Thread thread1 = new Thread(myrunnbale);
		Thread thread2 = new Thread(myrunnbale);

		thread1.start();
		thread2.start();
	}
}
