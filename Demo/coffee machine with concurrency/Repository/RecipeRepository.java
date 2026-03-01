package Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import domain.BeverageType;
import domain.Recipe;

public class RecipeRepository {
    private Map<BeverageType, Recipe> recipeMap;

    public RecipeRepository() {
        this.recipeMap = new HashMap<>();
    }

    public void save(Recipe recipe) {
        System.out.println("Added recipe to the recipe map!");
        recipeMap.put(recipe.getBeverageType(), recipe);
    }

    public Optional<Recipe> getRecipe(BeverageType beverageType) {
        return Optional.ofNullable(recipeMap.get(beverageType));
    }

    public void deleteRecipe(Recipe recipe) {
        recipeMap.remove(recipe.getBeverageType());
        System.out.println("Removed recipe for: " + recipe.getBeverageType());
    }
}
