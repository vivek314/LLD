package behavorial.observer;

import behavorial.observer.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannelImpl {
	List<Subscriber> subscribers = new ArrayList<>();
	private String video;
	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}
	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}
	private void notifySubscribers() {
		subscribers.forEach(subscriber ->  subscriber.update(this.video));
	}

	public void addVideo(String video) {
		this.video = video;
		notifySubscribers();
	}

}
