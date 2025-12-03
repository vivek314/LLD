package LibraryManagementSystem.states;

import LibraryManagementSystem.BookCopy;
import LibraryManagementSystem.Member;

public interface ItemState {
	void borrowItem(BookCopy copy, Member member);
	void returnBook(BookCopy copy, Member member);
}
