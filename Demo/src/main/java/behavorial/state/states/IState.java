package behavorial.state.states;

import behavorial.state.StateContext;

public interface IState {
	void next(StateContext context);
	String getState();
}
