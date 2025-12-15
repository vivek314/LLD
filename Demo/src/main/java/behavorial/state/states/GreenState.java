package behavorial.state.states;

import behavorial.state.StateContext;

public class GreenState implements IState {

	@Override
	public void next(StateContext context) {
		System.out.println("GreenState next is Yellow");
		context.setState(new YellowState());
	}

	@Override
	public String getState() {
		return "GreenState";
	}
}
