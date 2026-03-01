package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recipe {
    UUID id;
    private BeverageType beverageType;
    private List<IngridientQuantity> ingridientQuantityList;

    public Recipe(BeverageType beverageType, List<IngridientQuantity> ingridientQuantities) {
        this.beverageType = beverageType;
        this.ingridientQuantityList = ingridientQuantities;
    }

    public Recipe(BeverageType beverageType) {
        this(beverageType, new ArrayList<>());
    }

    public void addIngridientsToTheBeverage(IngridientType ingridientType, int quantity) {
        ingridientQuantityList.add(new IngridientQuantity(ingridientType, quantity));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BeverageType getBeverageType() {
        return beverageType;
    }

    public void setBeverageType(BeverageType beverageType) {
        this.beverageType = beverageType;
    }

    public List<IngridientQuantity> getIngridientQuantityList() {
        return ingridientQuantityList;
    }

    public void setIngridientQuantityList(List<IngridientQuantity> ingridientQuantityList) {
        this.ingridientQuantityList = ingridientQuantityList;
    }

    
}
