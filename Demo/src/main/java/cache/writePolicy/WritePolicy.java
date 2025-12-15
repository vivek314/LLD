package cache.writePolicy;

import cache.CacheStorage;
import cache.DBStorage;

public interface WritePolicy<K,V> {
	void write(K key, V value, CacheStorage<K,V> cacheStorage, DBStorage<K,V> databaseStorage) throws Exception;
}
