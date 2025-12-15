package cache.eviction;

import cache.DoubleLinkedList;
import cache.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionAlgorithm<K> implements EvictionAlgorithm<K> {
	private final DoubleLinkedList<K> dll;
	private final Map<K, DoubleLinkedListNode<K>> keyToNodeMap;

	public LRUEvictionAlgorithm(){
		dll = new DoubleLinkedList<>();
		keyToNodeMap = new HashMap<K, DoubleLinkedListNode<K>>();
	}

	@Override
	public void keyAccessed(K key) throws Exception {
		if(keyToNodeMap.containsKey(key)){
			DoubleLinkedListNode<K> node = keyToNodeMap.get(key);
			dll.detachNode(node);
			dll.addNodeAtHead(node);
		} else{
			DoubleLinkedListNode<K> node = new DoubleLinkedListNode<>(key);
			dll.addNodeAtHead(node);
			keyToNodeMap.put(key, node);
		}
	}

	@Override
	public K evictKey() throws Exception {
		DoubleLinkedListNode<K> node = dll.getTail();
		if(node == null){
			return null;
		}
		else{
			K key = node.getValue();
			dll.removeTail();
			keyToNodeMap.remove(key);
			return key;
		}
	}
}
