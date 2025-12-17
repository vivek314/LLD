package kafka;

public interface IPublisher {
	int getId();
	void publish(Topic topic, Message message);
}
