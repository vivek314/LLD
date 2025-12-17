package kafka;

public class TopicPublisherController {
	private final TopicPublisher topicPublisher;
	public TopicPublisherController(TopicPublisher topicPublisher) {
		this.topicPublisher = topicPublisher;
	}
	public synchronized void publish(Topic topic, Message message) {
		topicPublisher.getPublisher().publish(topic, message);
	}
}
