package behavorial.state;

import behavorial.state.states.GreenState;
import behavorial.state.states.IState;
import behavorial.state.states.RedState;

public class StateContext {
	private IState currState;
	public StateContext() {
		this.currState = new RedState();
	}

	public void next(){
		currState.next(this);
	}

	public void setState(IState state) {
		currState = state;
	}

	public String getState() {
		return currState.getState();
	}
}
