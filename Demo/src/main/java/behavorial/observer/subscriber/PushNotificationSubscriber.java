package behavorial.observer.subscriber;

public class PushNotificationSubscriber implements Subscriber {
	public void update(String video) {
		System.out.println("Push Notification Subscriber, got a new video" +  video);
	}
}
