package cache;

public class DoubleLinkedListNode<K> {
	private final K value;
	DoubleLinkedListNode<K> next;
	DoubleLinkedListNode<K> prev;

	public DoubleLinkedListNode(K value) {
		this.value = value;
		next = null;
		prev = null;
	}

	public K getValue() {
		return value;
	}
}
