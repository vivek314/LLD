package cache;

import cache.eviction.EvictionAlgorithm;
import cache.eviction.LRUEvictionAlgorithm;
import cache.writePolicy.WritePolicy;
import cache.writePolicy.WriteThroughPolicy;

import java.util.concurrent.ConcurrentHashMap;

public class Main {
	public static void main(String[] args) {
		try{
			CacheStorage<String, String> cacheStorage = new InMemoryCacheStorage<>(5);
			DBStorage<String, String> dbStorage = new SimpleDBStorage<>();
			WritePolicy<String, String> writePolicy = new WriteThroughPolicy<>();
			EvictionAlgorithm<String> evictionAlgorithm = new LRUEvictionAlgorithm<>();
			Cache<String, String> cache = new Cache<>(cacheStorage, dbStorage, writePolicy, evictionAlgorithm, 5);

			cache.update("A", "Apple").join();
			cache.update("B", "Banana").join();
			cache.update("C", "Cherry").join();
			cache.update("D", "Durian").join();
			cache.update("E", "Enamel").join();

			cache.update("F", "Frank").join();
			try {
				String valueA = cache.accessData("A").join();
				System.out.println(valueA);
			} catch (Exception e) {
				System.out.println("A is evicted");
			}

			String valueF = cache.accessData("F").join();
			System.out.println(valueF);

			cache.update("B", "Balayya").join();
			String valueB = cache.accessData("B").join();
			System.out.println(valueB);

			cache.shutDown();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
