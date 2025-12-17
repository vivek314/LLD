package kafka;

public class TopicSubscriberController implements Runnable {
	private final TopicSubscriber topicSubscriber;
	public TopicSubscriberController(TopicSubscriber topicSubscriber){
		this.topicSubscriber = topicSubscriber;
	}

	@Override
	public void run() {
		Message messageToProcess;
		while(true){
			synchronized (topicSubscriber){
				if(topicSubscriber.getOffset().get() >= topicSubscriber.getTopic().getSize()){
					try {
						topicSubscriber.wait();
					} catch (InterruptedException e) {
						System.out.println("TopicSubscriberController run interrupted");
//						e.printStackTrace();
					}
				}
				int currentOffset = topicSubscriber.getOffset().getAndIncrement();
				messageToProcess = topicSubscriber.getTopic().getMessages().get(currentOffset);
			}
			//since this may take some time if it is there inside,
			//other threads will become late, also it can process seperately
			topicSubscriber.getSubscriber().onMessage(messageToProcess);
		}
	}
}
