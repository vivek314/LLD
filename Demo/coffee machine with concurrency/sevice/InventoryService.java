package sevice;

import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

import Repository.InventoryRepository;
import domain.BeverageType;
import domain.IngridientQuantity;
import domain.IngridientType;
import domain.Recipe;
import Repository.RecipeRepository;

public class InventoryService {
    private InventoryRepository inventoryRepository;
    private RecipeRepository recipeRepository;
    private final ReentrantLock lock = new ReentrantLock();

    public InventoryService(InventoryRepository inventoryRepository, RecipeRepository recipeRepository) {
        this.inventoryRepository = inventoryRepository;
        this.recipeRepository = recipeRepository;
    }

    public Boolean checkAndRemove(BeverageType beverageType) {
        lock.lock(); // block briefly — correctness matters here over responsiveness
        try {
            if (checkIfAvailable(beverageType)) {
                removeInventory(beverageType);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public Boolean checkIfAvailable(BeverageType type) {
        Optional<Recipe> recipe = recipeRepository.getRecipe(type);
        if (!recipe.isPresent()) {
            System.out.println("Unknown recipe found and could not be made");
            return false;
        }
        for (IngridientQuantity ingridientQuantity : recipe.get().getIngridientQuantityList()) {
            if (!inventoryRepository.checkIfAvailable(ingridientQuantity.getType(), ingridientQuantity.getQuantity())) {
                System.out.println(
                        "Ingridient " + ingridientQuantity.getType() + " is not available in sufficient quantity");
                return false;
            }
        }
        return true;
    }

    public void removeInventory(BeverageType type) {
        Optional<Recipe> recipe = recipeRepository.getRecipe(type);
        if (!recipe.isPresent()) {
            System.out.println("Unknown recipe found and could not be made");
            return;
        }
        for (IngridientQuantity ingridientQuantity : recipe.get().getIngridientQuantityList()) {
            inventoryRepository.removeItems(ingridientQuantity.getType(), ingridientQuantity.getQuantity());
        }
    }

    public void removeInventory(IngridientType type, int quantity) {
        inventoryRepository.removeItems(type, quantity);
    }

    public void addInventory(IngridientType type, int quantity) {
        inventoryRepository.addItem(type, quantity);
    }
}
