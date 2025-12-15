package ATM;

public class User {
	private final String name;
	private String pin;
	private final String userId;
	private BalanceController  balanceController;
	public User(String name, String pin, String userId) {
		this.name = name;
		this.pin = pin;
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getUserId() {
		return userId;
	}
	public void addMoney(float money){
		balanceController.addMoney(userId, money);
	}
	public void printBalance() {
		balanceController.printBalance(userId);
	}
	public void deductMoney(float money) {
		balanceController.deductMoney(userId, money);
	}
}
