package kafka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic {
	private final String topicName;
	private final int topicId;
	private final List<Message> messages;
	public Topic(String topicName, int topicId) {
		this.topicName = topicName;
		this.topicId = topicId;
		messages = new ArrayList<Message>();
	}
	public String getTopicName() {
		return topicName;
	}
	public int getTopicId() {
		return topicId;
	}

	public synchronized void addMessage(Message message){
		messages.add(message);
	}

	public int getSize(){
		return messages.size();
	}

	public synchronized List<Message> getMessages(){
		return messages;
	}
}
