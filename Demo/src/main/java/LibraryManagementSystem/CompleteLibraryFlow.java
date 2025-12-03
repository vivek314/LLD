package LibraryManagementSystem;

public class CompleteLibraryFlow {
	public static void main(String[] args) {
		LibrarySystem lib = LibrarySystem.getInstance();

		// 1. SETUP: Add Inventory (Factory creates metadata once)
		System.out.println("--- Setup ---");
		lib.addBook("ISBN-1", "Design Patterns", "GoF", 1); // 1 Copy created
		lib.addMember("M01", "Praveen");
		lib.addMember("M02", "Alice");

		// 2. BORROW: Praveen borrows the only copy
		System.out.println("\n--- Borrowing ---");
		lib.borrowItem("ISBN-1-C1", "M01");

		// 3. WAITLIST: Alice tries to borrow, finds it taken, subscribes
		System.out.println("\n--- Waitlist Subscription ---");
		lib.borrowItem("ISBN-1-C1", "M02"); // Fails
		lib.subscribeToWaitList("ISBN-1", "M02"); // Alice subscribes to metadata

		// 4. RETURN: Praveen returns book -> Trigger Notification for Alice
		System.out.println("\n--- Return & Notify ---");
		lib.returnItem("ISBN-1-C1", "M01");

		// 5. PAYMENT: Praveen pays his fine (if generated)
		System.out.println("\n--- Payment ---");
//		lib.processPayment("M01", 50.0);
	}
}
