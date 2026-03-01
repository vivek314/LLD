package Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import domain.IngridientType;

public class InventoryRepository {
    private Map<IngridientType, Integer> ingridientMap;

    public InventoryRepository() {
        ingridientMap = new ConcurrentHashMap<>();
        for (IngridientType type : IngridientType.values()) {
            ingridientMap.put(type, 0);
        }
    }

    public void addItem(IngridientType type, int quantity) {
        if (!ingridientMap.containsKey(type)) {
            System.err.println("Could not find ingridient found in the ingrident map");
        }
        ingridientMap.compute(type, (k, v) -> v + quantity);
    }

    public Boolean checkIfAvailable(IngridientType type, int quantity) {
        if (!ingridientMap.containsKey(type)) {
            System.err.println("Could not find ingridient found in the ingrident map");
        }
        return ingridientMap.get(type) >= quantity;
    }

    public void removeItems(IngridientType type, int quantity) {
        if (!ingridientMap.containsKey(type)) {
            System.err.println("Could not find ingridient found in the ingrident map");
        }
        if (!checkIfAvailable(type, quantity)) {
            System.err.println("Quantity not sufficient to deduct for this item: " + type);
        }
        ingridientMap.compute(type, (k, v) -> v - quantity);
    }
}
