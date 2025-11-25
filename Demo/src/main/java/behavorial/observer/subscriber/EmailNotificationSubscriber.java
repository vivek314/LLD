package behavorial.observer.subscriber;

public class EmailNotificationSubscriber implements Subscriber {
	public void update(String video) {
		System.out.println("Email Notification Subscriber, got a new video" +  video);
	}
}
