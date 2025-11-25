package behavorial.observer;

import behavorial.observer.subscriber.EmailNotificationSubscriber;
import behavorial.observer.subscriber.PushNotificationSubscriber;
import behavorial.observer.subscriber.Subscriber;

public class Main {
	public static void main(String[] args) {
		YoutubeChannelImpl channel = new YoutubeChannelImpl();
		Subscriber email = new EmailNotificationSubscriber();
		Subscriber push = new PushNotificationSubscriber();
		channel.addSubscriber(email);
		channel.addSubscriber(push);
		channel.addVideo(" Vivek vlog");
	}
}
