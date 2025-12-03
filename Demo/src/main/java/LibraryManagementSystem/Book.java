package LibraryManagementSystem;

import java.util.UUID;

public class Book extends LibraryItem {
	private String author;
	public Book(String id, String title, String author) {
		super(id, title);
		this.author = author;
	}
}

