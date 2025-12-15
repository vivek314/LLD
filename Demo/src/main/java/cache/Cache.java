package cache;

import cache.eviction.EvictionAlgorithm;
import cache.writePolicy.WritePolicy;

import java.util.concurrent.CompletableFuture;

public class Cache<K,V> {
	private final CacheStorage<K, V> cacheStorage;
	private final DBStorage<K, V> dbStorage;
	private final WritePolicy<K, V> writePolicy;
	private final EvictionAlgorithm<K> evictionAlgorithm;
	private final KeyBasedExecutor keyBasedExecutor;

	public Cache(CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage, WritePolicy<K, V> writePolicy,
			EvictionAlgorithm<K> evictionAlgorithm, int numExecutors) {
		this.cacheStorage = cacheStorage;
		this.dbStorage = dbStorage;
		this.writePolicy = writePolicy;
		this.evictionAlgorithm = evictionAlgorithm;
		this.keyBasedExecutor = new KeyBasedExecutor(numExecutors);
	}

	public CompletableFuture<V> accessData(K key){
		return keyBasedExecutor.submitTask(key, () -> {
			try {
				if(!cacheStorage.containsKey(key)){
					throw new Exception("Key not found");
				}
				evictionAlgorithm.keyAccessed(key);
				return cacheStorage.get(key);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}

	public CompletableFuture<Void> update(K key, V value){
		return keyBasedExecutor.submitTask(key, () -> {
			try {
				if(cacheStorage.containsKey(key)){
					writePolicy.write(key, value, cacheStorage, dbStorage);
					evictionAlgorithm.keyAccessed(key);
				} else{
					if(cacheStorage.size() >= cacheStorage.getCapacity()){
						K evictedKey = evictionAlgorithm.evictKey();
						if(evictedKey != null){
							int currentIndex = keyBasedExecutor.getExecutorIndexForKey(key);
							int evictedIndex = keyBasedExecutor.getExecutorIndexForKey(evictedKey);
							if(currentIndex == evictedIndex){
								cacheStorage.remove(evictedKey);
							} else{
								CompletableFuture<Void> removalFuture = keyBasedExecutor.submitTask(evictedKey, () -> {
									try {
										cacheStorage.remove(evictedKey);
										return null;
									} catch (Exception e) {
										throw new RuntimeException(e);
									}
								});
								removalFuture.join();
							}
						}
					}
					writePolicy.write(key, value, cacheStorage, dbStorage);
					evictionAlgorithm.keyAccessed(key);
				}
				return null;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});
	}

	public void shutDown(){
		keyBasedExecutor.shutdown();
	}
}
