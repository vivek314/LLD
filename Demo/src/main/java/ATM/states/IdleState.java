package ATM.states;

import ATM.ATMService;
import ATM.User;

import java.util.Map;
import java.util.Scanner;

public class IdleState implements IState {

	@Override
	public void authenticate(Map<String, User> userMap, User user, ATMService atmService) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Pin: ");
		String pin = sc.nextLine();
		if(pin.equals(userMap.get(user.getUserId()).getPin())){
			atmService.setState(new TransactionState());
		} else{
			System.err.println("Invalid Pin");
		}
	}

	@Override
	public void balanceEnquiry(User user,  ATMService atmService) {
		System.out.println("User name: " +  user.getName() + " not authenticated");
	}

	@Override
	public void cashWithdrawl(User user, float amount,  ATMService atmService) {
		System.out.println("User name: " +  user.getName() + " not authenticated");
	}

	@Override
	public void cashDeposit(User user, float amount, ATMService atmService) {
		System.out.println("User name: " +  user.getName() + " not authenticated");
	}

	@Override
	public void exitOperation(ATMService atmService) {
		System.out.println("User halted the process!, starting again");
		atmService.setState(new IdleState());
	}

	@Override
	public String getState() {
		return "Idle State";
	}
}
