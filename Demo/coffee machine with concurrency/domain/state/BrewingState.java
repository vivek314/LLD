package domain.state;

import domain.BeverageType;
import domain.CoffeMachine;

public class BrewingState implements CoffeeMachineState {
    @Override
    public void selectBeverage(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot select beverage while brewing");
    }

    @Override
    public void brew(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Please wait while we brew your beverage: " + beverageType);
        if (checkForTransition(new DispensingState().getStateName()))
            coffeMachine.setState(new DispensingState());
    }

    @Override
    public String getStateName() {
        return "Brewing";
    }

    @Override
    public void refill(CoffeMachine coffeMachine) {
        System.out.println("Cannot refill while brewing");
    }

    @Override
    public Boolean checkForTransition(String stateName) {
        return stateName.equals("Dispensing");
    }

    @Override
    public void dispensing(CoffeMachine coffeMachine) {
        System.out.println("Cannot dispense while brewing");
    }
}
