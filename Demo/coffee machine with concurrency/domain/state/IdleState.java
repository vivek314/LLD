package domain.state;

import domain.BeverageType;
import domain.CoffeMachine;

public class IdleState implements CoffeeMachineState {
    @Override
    public void selectBeverage(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Beverage selected: " + beverageType);
        if (checkForTransition(new BrewingState().getStateName()))
            coffeMachine.setState(new BrewingState());
    }

    @Override
    public void refill(CoffeMachine coffeMachine) {
        System.out.println("Cannot refill while selecting Beverage");
    }

    @Override
    public String getStateName() {
        return "Idle";
    }

    @Override
    public Boolean checkForTransition(String stateName) {
        return stateName.equals("Brewing") || stateName.equals("Refill");
    }

    @Override
    public void dispensing(CoffeMachine coffeMachine) {
        System.out.println("Cannot dispense while selecting ingridients");
    }

    @Override
    public void brew(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot brew while selecting Beverage");
    }

}
