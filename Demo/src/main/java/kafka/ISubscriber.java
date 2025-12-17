package kafka;

public interface ISubscriber {
	int getId();
	void onMessage(Message message);
}
