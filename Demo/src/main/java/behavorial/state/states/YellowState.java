package behavorial.state.states;

import behavorial.state.StateContext;

public class YellowState implements IState {
	@Override
	public void next(StateContext context) {
		System.out.println("YellowState next is Red");
		context.setState(new RedState());
	}

	@Override
	public String getState() {
		return "YellowState";
	}
}
