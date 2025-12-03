package LibraryManagementSystem;

import LibraryManagementSystem.payment.PaymentStrategy;

public class Member {
	private String id;
	private String name;
	private double findBalance = 0.0;

	public Member(String id, String name){
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void update(String title){
		System.out.println("MSG: "+ title);
	}
	public void addFine(double amount){
		findBalance = findBalance + amount;
		System.out.println("FINE: "+ findBalance);
	}
	public void payFine(double amount, PaymentStrategy paymentMethod){
		if(amount<=findBalance){
			paymentMethod.pay(amount);
			findBalance = findBalance - amount;
			System.out.println("FINE paid and remaining balance: "+ findBalance);
		}else{
			System.out.println("FINE payment not enough");
		}
	}

}
