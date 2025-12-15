package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		scheduledExecutorService.schedule(() -> System.out.println(Thread.currentThread().getName() + ": Calling notify"),
				5, TimeUnit.SECONDS);
	}
}
