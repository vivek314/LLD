package ATM.states;

import ATM.ATMService;
import ATM.User;

import java.util.Map;

public interface IState {
	void authenticate(Map<String, User> userMap, User user, ATMService atmService);
	void balanceEnquiry(User user,  ATMService atmService);
	void cashWithdrawl(User user, float amount, ATMService atmService);
	void cashDeposit(User user, float amount, ATMService atmService);
	void exitOperation( ATMService atmService);
	String getState();
}
