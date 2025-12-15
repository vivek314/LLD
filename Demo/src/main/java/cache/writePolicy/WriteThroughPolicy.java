package cache.writePolicy;

import cache.CacheStorage;
import cache.DBStorage;

import java.util.concurrent.CompletableFuture;

public class WriteThroughPolicy<K,V> implements WritePolicy<K,V> {
//Interaction of cache with db for a specific key value pair
	@Override
	public void write(K key, V value, CacheStorage<K, V> cacheStorage, DBStorage<K, V> databaseStorage)
			throws Exception {
		CompletableFuture<Void> cacheFuture = CompletableFuture.runAsync(() -> {
			try {
				cacheStorage.put(key, value);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});

		CompletableFuture<Void> databaseFuture = CompletableFuture.runAsync(() -> {
			try {
				databaseStorage.write(key, value);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		});

		CompletableFuture.allOf(cacheFuture,databaseFuture).join();
	}
}
