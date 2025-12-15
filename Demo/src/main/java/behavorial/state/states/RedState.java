package behavorial.state.states;

import behavorial.state.StateContext;

public class RedState implements IState {
	@Override
	public void next(StateContext ctx) {
		System.out.println("RedState next is Green");
		ctx.setState(new GreenState());
	}

	@Override
	public String getState() {
	return "RedState";
	}
}
