package domain;

public class IngridientQuantity {
    private IngridientType type;
    private int quantity;

    public IngridientQuantity(IngridientType type, int quantity) {
        this.type = type;
        this.quantity = quantity;

    }

    public IngridientType getType() {
        return type;
    }

    public void setType(IngridientType type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
