package ATM.states;

import ATM.ATMService;
import ATM.User;

import java.util.Map;

public class TransactionState implements IState {
	@Override
	public void authenticate(Map<String, User> userMap, User user, ATMService atmService) {
		System.out.println("Already user authenticated");
	}

	@Override
	public void balanceEnquiry(User user, ATMService atmService) {
		user.printBalance();
		atmService.setState(new IdleState());
	}

	@Override
	public void cashWithdrawl(User user, float amount, ATMService atmService) {
		user.deductMoney(amount);
		atmService.setState(new IdleState());
	}

	@Override
	public void cashDeposit(User user, float amount,  ATMService atmService) {
		user.addMoney(amount);
		atmService.setState(new IdleState());
	}

	@Override
	public void exitOperation(ATMService atmService) {
		System.out.println("User halted the process!, starting again");
	}

	@Override
	public String getState() {
		return "TransactionState";
	}
}
