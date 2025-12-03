package LibraryManagementSystem.states;

import LibraryManagementSystem.BookCopy;
import LibraryManagementSystem.Member;

public class CheckOutState implements ItemState {

	@Override
	public void borrowItem(BookCopy copy, Member member) {
		System.out.println("Error: already took by someone else");
	}

	@Override
	public void returnBook(BookCopy copy, Member member) {
		copy.setCurrentState(new AvailableState());
		System.out.println("Successfully returned book : "+ copy.getCopyId()+ " by user: "+ member.getName());
		copy.getItem().notifyObservers();
	}
}
