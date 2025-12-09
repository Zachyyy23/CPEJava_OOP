package shared;

import SimplePOS.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderRepo {

    private static final List<Order> orders = new ArrayList<>();

    public static void add(Order a) {
        orders.add(a);
    }

    public static List<Order> getAll() {
        return orders;
    }
}
