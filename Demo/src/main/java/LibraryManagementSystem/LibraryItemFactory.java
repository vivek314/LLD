package LibraryManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class LibraryItemFactory {
	private static final Map<String, LibraryItem> itemCache = new HashMap<>();
	public static LibraryItem getItem(String id, String title, String author, ItemType type) {
		if(itemCache.containsKey(id)) {
			return itemCache.get(id);
		}

		LibraryItem newItem;
		newItem = new Book(id, title, author);

		itemCache.put(id, newItem);
		return newItem;
	}

}
