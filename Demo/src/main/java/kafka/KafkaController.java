package kafka;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class KafkaController {
	private final Map<Integer, Topic> topics;
	private final Map<Integer, List<TopicSubscriber>> topicSubscribers;
	private final ExecutorService subscriberExecutor;
	private final AtomicInteger topicIdCounter;

	public KafkaController(){
		topics = new ConcurrentHashMap<>();
		topicSubscribers = new ConcurrentHashMap<>();
		subscriberExecutor = Executors.newCachedThreadPool();
		topicIdCounter = new AtomicInteger(0);
	}

	public Topic createTopic(String topicName){
		int topicId = topicIdCounter.incrementAndGet();
		Topic topic = new Topic(topicName, topicId);
		topics.put(topicId, topic);
		topicSubscribers.put(topicId, new CopyOnWriteArrayList<>());
		System.out.println("Created topic " + topicName);
		return topic;
	}

	public void subscribeTopic(ISubscriber subscriber, int topicId){
		Topic topic = topics.get(topicId);
		if (topic == null) {
			System.err.println("Topic with id " + topicId + " does not exist");
			return;
		}
		TopicSubscriber ts = new TopicSubscriber(topic, subscriber);
		topicSubscribers.get(topicId).add(ts);
		subscriberExecutor.submit(new TopicSubscriberController(ts));
		System.out.println("Subscriber: " + subscriber.getId() + " subscribed to topic: " + topicId);
	}

	public void publishMessage(IPublisher publisher, Message message, int topicId){
		Topic topic = topics.get(topicId);
		topic.getMessages().add(message);
		List<TopicSubscriber> subscribers = topicSubscribers.get(topicId);
		for(TopicSubscriber ts : subscribers){
			synchronized (ts){
				ts.notify();
			}
		}
	}

	public void resetOffset(ISubscriber subscriber, int newOffset, int topicId){
		Topic topic = topics.get(subscriber.getId());
		if(topic == null){
			System.out.println("Topic not found");
			return;
		}
		List<TopicSubscriber> topicSubscriberList = topicSubscribers.get(topicId);
		for(TopicSubscriber ts : topicSubscriberList){
			if(ts.getSubscriber().getId() == subscriber.getId()){
				ts.getOffset().set(newOffset);
				synchronized (ts){
					ts.notify();
				}
				System.out.println("Offset for subscriber " + subscriber.getId() + " on topic "
						+ ts.getTopic().getTopicName() + " reset to " + newOffset);
			}
		}
	}

	public void shutDown(){
		subscriberExecutor.shutdown();
		try{
			if(!subscriberExecutor.awaitTermination(5, TimeUnit.SECONDS)){
				subscriberExecutor.shutdownNow();
			}
		} catch (InterruptedException e) {
			subscriberExecutor.shutdownNow();
		}
	}

}
