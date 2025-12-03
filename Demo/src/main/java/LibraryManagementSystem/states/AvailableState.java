package LibraryManagementSystem.states;

import LibraryManagementSystem.BookCopy;
import LibraryManagementSystem.Member;

public class AvailableState implements ItemState {

	@Override
	public void borrowItem(BookCopy copy, Member member) {
		copy.setCurrentState(new CheckOutState());
		System.out.println("Borrowed this Book: " + copy.getCopyId() + " by user: " + member.getName());
	}

	@Override
	public void returnBook(BookCopy copy, Member member) {
		System.out.println("Error: already in library");
	}
}
