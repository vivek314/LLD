package ATM;

import java.util.HashMap;
import java.util.Map;

public class BalanceController {
	private Map<String, Float> balanceMap;
	public BalanceController(Map<String, Float> balanceMap) {
		this.balanceMap = new HashMap<String, Float>();
	}
	public Map<String, Float> getBalanceMap() {
		return balanceMap;
	}

	public void addUser(String userId, float balance) {
		balanceMap.put(userId, balance);
	}
	public void removeUser(String userId) {
		balanceMap.remove(userId);
	}
	public float getBalance(String userId) {
		if(balanceMap.containsKey(userId)) {
			return balanceMap.get(userId);
		}else{
			System.err.println("User with user Id: "+ userId + " not found");
			return 0;
		}

	}
	public void addMoney(String userId, float money) {
		balanceMap.put(userId, balanceMap.get(userId) + money);
		System.out.println("User with user Id: "+ userId +" added "+money);
	}
	public void printBalance(String userId) {
		System.out.println("User with user Id: "+ userId + " has balance: " + balanceMap.get(userId));
	}
	public void deductMoney(String userId, float money) {
		if(balanceMap.get(userId) >= money) {
			balanceMap.put(userId, balanceMap.get(userId) - money);
			System.out.println("User with user Id: "+ userId + " deducted " + money);
		}

	}
}
