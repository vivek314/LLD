package ATM.states;

import ATM.ATMService;
import ATM.User;

import java.util.Map;

public class DispenseState implements IState{

	@Override
	public void authenticate(Map<String, User> userMap, User user, ATMService atmService) {
		System.out.println("System is busy right now");
	}

	@Override
	public void balanceEnquiry(User user, ATMService atmService) {
		System.out.println("System is busy right now");
	}

	@Override
	public void cashWithdrawl(User user, float amount, ATMService atmService) {
		System.out.println("System is busy right now");
	}

	@Override
	public void cashDeposit(User user, float amount, ATMService atmService) {
		System.out.println("System is busy right now");
	}

	@Override
	public void exitOperation(ATMService atmService) {
		System.out.println("Process is completed");
		atmService.setState(new IdleState());
	}

	@Override
	public String getState() {
		return "DispenseState";
	}
}
