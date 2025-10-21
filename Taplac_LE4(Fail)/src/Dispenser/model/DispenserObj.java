package Dispenser.model;

public class DispenserObj {
    private String name;
    private int noOfItems;
    private double itemCost;

    public DispenserObj(String name, int noOfItems, double itemCost) {
        this.name = name;
        this.noOfItems = noOfItems;
        this.itemCost = itemCost;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
