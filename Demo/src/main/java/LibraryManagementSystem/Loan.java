package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
	private final String loanId;
	private final BookCopy bookCopy;
	private final Member member;
	private final LocalDate borrowDate;
	private LocalDate returnDate;
	private final LocalDate dueDate;

	public Loan(BookCopy bookCopy, Member member, LocalDate dueDate) {
		this.loanId = UUID.randomUUID().toString();
		this.bookCopy = bookCopy;
		this.member = member;
		this.borrowDate = LocalDate.now();
		this.dueDate = dueDate;
	}

	public String getLoanId() {
		return loanId;
	}
	public BookCopy getBookCopy() {
		return bookCopy;
	}
	public Member getMember() {
		return member;
	}
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

}
