package LibraryManagementSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LibrarySystem {
	private static LibrarySystem instance;

	private Map<String, BookCopy> inventory = new ConcurrentHashMap<>();
	private Map<String, Member> members = new ConcurrentHashMap<>();

	private Map<String, LibraryItem> menu = new ConcurrentHashMap<>();

	private LibrarySystem(){}

	public static synchronized LibrarySystem getInstance(){
		if(instance == null){
			instance = new LibrarySystem();
		}
		return instance;
	}

	public void addBook(String isbn, String title, String author, int count){
		LibraryItem item = LibraryItemFactory.getItem(isbn, title, author, ItemType.BOOK);
		menu.put(isbn, item);

		for(int i=1;i<=count;i++){
			String copyId = isbn + "-C" + i;
			BookCopy copy = new BookCopy(copyId, item);
			inventory.put(copyId, copy);
		}
	}

	public void addMember(String id, String name){
		members.put(id, new Member(id, name));
	}

	public void borrowItem(String copyId, String memberId){
		BookCopy bookCopy = inventory.get(copyId);
		Member member = members.get(memberId);
		if(bookCopy!=null && member!=null){
			bookCopy.borrowItem(member);
		}
	}

	public void returnItem(String copyId, String memberId){
		BookCopy bookCopy = inventory.get(copyId);
		Member member = members.get(memberId);
		if(bookCopy!=null && member!=null){
			bookCopy.returnBook(member);
		}
	}

	public void subscribeToWaitList(String isbn, String memberId){
		Member member = members.get(memberId);
		LibraryItem item = menu.get(isbn);
		if(item!=null && member!=null){
			item.addObserver(member);
		}
	}
}

