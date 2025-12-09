package SimplePOS.model;

public class Order {
    private int orderID;
    private String name;
    private int quantity;
    private double price;
    private String status;

    public Order(int orderID, String name, int quantity, double price, String status) {
        this.orderID = orderID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return orderID + " | " + name + " | x" + quantity + " | ₱" + price + " | " + status;
    }
}
