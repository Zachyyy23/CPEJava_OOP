package Dispenser.model;

public class DispenserObj {
    private int numberOfItems;
    private int cost;

    public DispenserObj() {
        this.numberOfItems = 50;
        this.cost = 50;
    }

    public DispenserObj(int setNoOfItems, int setCost) {
        this.numberOfItems = setNoOfItems;
        this.cost = setCost;
    }

    public int getNoOfItems() {
        return numberOfItems;
    }

    public int getCost() {
        return cost;
    }

    public void makeSale() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }
    }
}
