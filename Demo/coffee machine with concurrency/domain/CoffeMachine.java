package domain;

import java.util.concurrent.locks.ReentrantLock;

import Repository.RecipeRepository;
import domain.state.CoffeeMachineState;
import domain.state.IdleState;
import sevice.InventoryService;

public class CoffeMachine {
    int id; // there for extensibility if extended to multiple machines
    InventoryService inventoryService;
    RecipeRepository recipeRepository;
    private CoffeeMachineState coffeeMachineState;
    private final ReentrantLock lock = new ReentrantLock();

    public CoffeMachine(int id, InventoryService inventoryService, RecipeRepository recipeRepository) {
        this.id = id;
        this.inventoryService = inventoryService;
        this.recipeRepository = recipeRepository;
        this.coffeeMachineState = new IdleState();
    }

    public void setState(CoffeeMachineState coffeeMachineState) {
        this.coffeeMachineState = coffeeMachineState;
    }

    public CoffeeMachineState getState() {
        return this.coffeeMachineState;
    }

    public void selectBeverage(BeverageType beverageType) {
        coffeeMachineState.selectBeverage(this, beverageType);
    }

    public void brew(BeverageType beverageType) {
        if (inventoryService.checkAndRemove(beverageType)) {
            coffeeMachineState.brew(this, beverageType);
        } else {
            System.out.println("Ingredients are not available, please refill");
            setState(new IdleState());
        }
    }

    public void refill(IngridientType type, int quantity) {
        coffeeMachineState.refill(this);
        inventoryService.addInventory(type, quantity);
    }

    public void dispensing() {
        coffeeMachineState.dispensing(this);
    }

    // making use of command pattern to make the process of brewing and dispensing
    public void prepareBeverage(BeverageType beverageType) {
        if (lock.tryLock()) {
            try {
                selectBeverage(beverageType);
                brew(beverageType);
                dispensing();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Machine is busy, try again later.");
        }
    }
}
