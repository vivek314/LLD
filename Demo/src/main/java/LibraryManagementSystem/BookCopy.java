package LibraryManagementSystem;

import LibraryManagementSystem.states.AvailableState;
import LibraryManagementSystem.states.ItemState;

public class BookCopy {
	private final String copyId;
	private LibraryItem item; //using flyweight pattern for reducing redundancy and not repeating intrinsic objects
	private ItemState currentState;

	public BookCopy(String copyId, LibraryItem item) {
		this.copyId = copyId;
		this.item = item;
		this.currentState = new AvailableState();
	}

	public String getCopyId() {
		return copyId;
	}
	public LibraryItem getItem() {
		return item;
	}
	public ItemState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(ItemState currentState) {
		this.currentState = currentState;
	}

	public void borrowItem(Member member) {
		currentState.borrowItem(this, member);
	}

	public void returnBook(Member member) {
		currentState.returnBook(this, member);
	}
}
