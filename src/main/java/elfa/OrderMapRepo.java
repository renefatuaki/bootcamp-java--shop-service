package elfa;

//Create a class OrderMapRepo through which we can place new orders.
//This class should also implement the OrderRepo interface.
//In the main method, create either the OrderMapRepo or the OrderListRepo and pass it to the constructor of ShopService (as a constructor parameter that uses the interface).

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orders = new HashMap<>();

    public OrderMapRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    public OrderMapRepo() {
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order getSingle(String id) {
        return this.orders.get(id);
    }

    @Override
    public Set<Order> getAll() {
        Collection<Order> orders = this.orders.values();
        return new HashSet<>(orders);
    }

    @Override
    public void add(Order order) {
        this.orders.put(Utility.createUUID(), order);
    }

    @Override
    public void remove(String id) {
        this.orders.remove(id);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
