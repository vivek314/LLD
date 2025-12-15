package cache;

public class DoubleLinkedList<K> {
	private DoubleLinkedListNode<K> head;
	private DoubleLinkedListNode<K> tail;

	public DoubleLinkedList(){
		head = null;
		tail = null;
	}

	public void addNodeAtHead(DoubleLinkedListNode<K> node){
		if(head == null){
			head = node;
			tail = node;
		} else{
			node.next = head;
			head.prev = node;
			head = node;
		}
		node.prev = null;
	}

	public void detachNode(DoubleLinkedListNode<K> node){
		if(node==null) return;
		if(node.prev==null){
			head = node.next;
			if(head!=null){
				head.prev = null;
			}else{
				tail = null;
			}
		}
		else if(node.next==null){
			tail = node.prev;
			if(tail!=null){
				tail.next = null;
			}
			else{
				head = null;
			}
		} else{
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	public DoubleLinkedListNode<K> getHead(){
		return head;
	}

	public DoubleLinkedListNode<K> getTail(){
		return tail;
	}
	public void removeTail(){
		if(tail!=null){
			if(tail.prev!=null){
				tail.prev.next = null;
				tail = tail.prev;
			} else{
				head = null;
				tail = null;
			}
		}
	}

}
