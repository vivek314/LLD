package kafka;

public class Main {
	public static void main(String[] args) {
		KafkaController controller = new KafkaController();
		int subCount = 1;
		int topicCount = 0;
		int pubCount = 0;
		ISubscriber subscriber1 = new SimpleSubscriber(subCount++);
		ISubscriber subscriber2 = new SimpleSubscriber(subCount++);
		ISubscriber subscriber3 = new SimpleSubscriber(subCount++);

		Topic topic1 = controller.createTopic("Topic-1");
		Topic topic2 = controller.createTopic("Topic-2");

		controller.subscribeTopic(subscriber1, topic1.getTopicId());
		controller.subscribeTopic(subscriber1, topic2.getTopicId());
		controller.subscribeTopic(subscriber2, topic1.getTopicId());
		controller.subscribeTopic(subscriber3, topic2.getTopicId());

		IPublisher publisher1 = new SimplePublisher(pubCount++, controller);
		IPublisher publisher2 = new SimplePublisher(pubCount++, controller);

		publisher1.publish(topic1, new Message("Message m1"));
		publisher1.publish(topic1, new Message("Message m2"));
		publisher2.publish(topic2, new Message("Message m3"));

		try{
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		publisher2.publish(topic2, new Message("Message m4"));
		publisher1.publish(topic1, new Message("Message m5"));

		controller.resetOffset(subscriber1, 0, topic1.getTopicId());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		controller.shutDown();
	}
}
