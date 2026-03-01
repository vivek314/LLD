import Repository.InventoryRepository;
import Repository.RecipeRepository;
import controller.AdminController;
import domain.BeverageType;
import domain.CoffeMachine;
import domain.IngridientType;
import domain.Recipe;
import sevice.AdminService;
import sevice.InventoryService;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Coffee Machine Simulation ===\n");

        // --- Setup Repositories ---
        InventoryRepository inventoryRepository = new InventoryRepository();
        RecipeRepository recipeRepository = new RecipeRepository();

        // --- Setup Services ---
        InventoryService inventoryService = new InventoryService(inventoryRepository, recipeRepository);
        AdminService adminService = new AdminService(inventoryService, recipeRepository);

        // --- Setup Controller ---
        AdminController adminController = new AdminController(adminService);

        // --- Setup Coffee Machine ---
        CoffeMachine machine = new CoffeMachine(1, inventoryService, recipeRepository);

        // --- Admin: Add Recipes ---
        System.out.println("--- Admin: Adding Recipes ---");

        Recipe latteRecipe = new Recipe(BeverageType.LATTE);
        latteRecipe.addIngridientsToTheBeverage(IngridientType.WATER, 50);
        latteRecipe.addIngridientsToTheBeverage(IngridientType.COFFEEBEANS, 18);
        latteRecipe.addIngridientsToTheBeverage(IngridientType.MILK, 150);
        adminController.addRecipe(latteRecipe);

        Recipe espressoRecipe = new Recipe(BeverageType.ESPRESSO);
        espressoRecipe.addIngridientsToTheBeverage(IngridientType.WATER, 50);
        espressoRecipe.addIngridientsToTheBeverage(IngridientType.COFFEEBEANS, 18);
        adminController.addRecipe(espressoRecipe);

        System.out.println();

        // --- Admin: Fill Inventory ---
        System.out.println("--- Admin: Filling Inventory ---");
        adminController.addIngridient(IngridientType.WATER, 200);
        adminController.addIngridient(IngridientType.COFFEEBEANS, 100);
        adminController.addIngridient(IngridientType.MILK, 200);
        adminController.addIngridient(IngridientType.SUGAR, 50);
        System.out.println("Inventory stocked!\n");

        // --- User: Order Latte (should succeed) ---
        System.out.println("--- User: Ordering a Latte ---");
        machine.prepareBeverage(BeverageType.LATTE);
        System.out.println();

        // --- User: Order Espresso (should succeed) ---
        System.out.println("--- User: Ordering an Espresso ---");
        machine.prepareBeverage(BeverageType.ESPRESSO);
        System.out.println();

        // --- User: Order Cappuccino (no recipe, should fail) ---
        System.out.println("--- User: Ordering a Cappuccino (no recipe added) ---");
        machine.prepareBeverage(BeverageType.CAPPUCCINO);
        System.out.println();

        // --- Admin: Refill water only ---
        System.out.println("--- Admin: Refilling Water ---");
        machine.refill(IngridientType.WATER, 500);
        System.out.println();

        // --- User: Order Latte when milk is exhausted (should fail) ---
        System.out.println("--- User: Ordering Latte with insufficient Milk ---");
        // Drain milk manually
        adminController.removeIngridient(IngridientType.MILK, 200);
        machine.prepareBeverage(BeverageType.LATTE);
        System.out.println();

        System.out.println("=== Simulation Complete ===");
    }
}
