package kafka;

public class SimplePublisher implements IPublisher{
	private final int id;
	private final KafkaController controller;

	public SimplePublisher(int id, KafkaController controller) {
		this.id = id;
		this.controller = controller;
	}
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void publish(Topic topic, Message message) {
		controller.publishMessage(this, message, topic.getTopicId());
		System.out.println("Publisher: " + id + " Published message to topic: " + topic.getTopicId());
	}
}
