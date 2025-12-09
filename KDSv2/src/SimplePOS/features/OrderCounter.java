package SimplePOS.features;

import SimplePOS.model.Order;
import java.util.ArrayList;

public class OrderCounter {

    private ArrayList<Order> orders;
    private int nextID = 1;

    public OrderCounter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public Order addIncrement(String itemName, double price) {
        for(Order a : orders) {
            if(a.getName().equalsIgnoreCase(itemName)) {
                a.setQuantity(a.getQuantity() + 1);
                return a;
            }
        }

        Order newOrder = new Order (nextID++, itemName, 1, price, "Pending");
        orders.add(newOrder);
        return newOrder;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
}
