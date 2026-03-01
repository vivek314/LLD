package sevice;

import Repository.RecipeRepository;
import domain.IngridientType;
import domain.Recipe;

public class AdminService {
    private InventoryService inventoryService;
    private RecipeRepository recipeRepository;

    public AdminService(InventoryService inventoryService, RecipeRepository recipeRepository) {
        this.inventoryService = inventoryService;
        this.recipeRepository = recipeRepository;
    }

    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipeRepository.deleteRecipe(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void addIngridient(IngridientType type, int quantity) {
        inventoryService.addInventory(type, quantity);
    }

    public void removeIngridient(IngridientType type, int quantity) {
        inventoryService.removeInventory(type, quantity);
    }
}
