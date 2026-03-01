package domain.state;

import domain.BeverageType;
import domain.CoffeMachine;

public interface CoffeeMachineState {
    void selectBeverage(CoffeMachine coffeMachine, BeverageType beverageType);

    void brew(CoffeMachine coffeMachine, BeverageType beverageType);

    void refill(CoffeMachine coffeMachine);

    String getStateName();

    void dispensing(CoffeMachine coffeMachine);

    Boolean checkForTransition(String stateName);
}
