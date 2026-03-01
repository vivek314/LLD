package domain.state;

import domain.BeverageType;
import domain.CoffeMachine;

public class RefillState implements CoffeeMachineState {
    @Override
    public void selectBeverage(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot select beverage while refilling");
    }

    @Override
    public void brew(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot brew while refilling");
    }

    @Override
    public String getStateName() {
        return "Refill";
    }

    @Override
    public void refill(CoffeMachine coffeMachine) {
        System.out.println("Refill completed");
        if (checkForTransition(new IdleState().getStateName()))
            coffeMachine.setState(new IdleState());
    }

    @Override
    public Boolean checkForTransition(String stateName) {
        return stateName.equals("Idle");
    }

    @Override
    public void dispensing(CoffeMachine coffeMachine) {
        System.out.println("Cannot dispense while refilling");
    }
}
