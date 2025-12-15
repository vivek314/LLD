package ATM;

import ATM.states.IState;
import ATM.states.IdleState;

import java.util.Map;

public class ATMService {
	Map<String, User> usersMap;
	float balance = 0;
	private static ATMService instance;
	private IState currentState;
	private ATMService() {
		this.currentState = new IdleState();
	}

	public static ATMService getInstance() {
		if(instance == null) {
			instance = new ATMService();
		}
		return instance;
	}
	//Delegates
	public IState getCurrentState() {
		return currentState;
	}

	public void authenticate(User user) {
		currentState.authenticate(usersMap, user, this);
	}

	public void deductMoney(String userId, float money) {
		currentState.cashWithdrawl(usersMap.get(userId), money, this);
	}

	public void addMoney(String userId, float money) {
		currentState.cashDeposit(usersMap.get(userId), money, this);
	}

	public void exitOperation(){
		currentState.exitOperation(this);
	}

	public void setState(IState currentState) {
		this.currentState = currentState;
	}
}
