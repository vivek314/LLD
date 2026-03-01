package domain.state;

import domain.BeverageType;
import domain.CoffeMachine;

public class DispensingState implements CoffeeMachineState {
    @Override
    public void selectBeverage(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot select beverage while dispensing");
    }

    @Override
    public void brew(CoffeMachine coffeMachine, BeverageType beverageType) {
        System.out.println("Cannot brew while dispensing");
    }

    @Override
    public String getStateName() {
        return "Dispensing";
    }

    @Override
    public void refill(CoffeMachine coffeMachine) {
        System.out.println("Cannot refill while dispensing");
    }

    @Override
    public Boolean checkForTransition(String stateName) {
        return stateName.equals("Idle");
    }

    @Override
    public void dispensing(CoffeMachine coffeMachine) {
        System.out.println("Dispensing completed");
        if (checkForTransition(new IdleState().getStateName()))
            coffeMachine.setState(new IdleState());
    }
}
