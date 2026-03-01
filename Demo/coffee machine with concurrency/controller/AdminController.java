package controller;

import domain.IngridientType;
import domain.Recipe;
import sevice.AdminService;

public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public void addRecipe(Recipe recipe) {
        adminService.addRecipe(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        adminService.removeRecipe(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        adminService.updateRecipe(recipe);
    }

    public void addIngridient(IngridientType type, int quantity) {
        adminService.addIngridient(type, quantity);
    }

    public void removeIngridient(IngridientType type, int quantity) {
        adminService.removeIngridient(type, quantity);
    }
}
