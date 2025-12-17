package kafka;

public class SimpleSubscriber implements ISubscriber{
	private final int id;

	public SimpleSubscriber(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void onMessage(Message message) {
		System.out.println("Subscriber " + id + " received: " + message.getMessage());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
