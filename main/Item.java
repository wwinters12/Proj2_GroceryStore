package main;

public class Item {
    private String name;
    private double price;
    private boolean isTaxed;
    private int quantity;

    public Item(String nameIn, double priceIn, boolean isTaxedIn, int quantityIn) {
        this.name = nameIn;
        this.price = priceIn;
        this.isTaxed = isTaxedIn;
        this.quantity = quantityIn;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isTaxed() {
        return isTaxed;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
