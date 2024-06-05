package elfa;

//Step 1: Create a record Order with the necessary attributes.
//Step 2: Implement the OrderListRepo class with a list to store orders.
//Step 3: Implement methods to add, remove, and (single order and all orders).

import java.util.HashSet;
import java.util.Set;

public class OrderListRepo implements OrderRepo {
    private Set<Order> orders = new HashSet<>();

    public OrderListRepo(Set<Order> orders) {
        this.orders = orders;
    }

    public OrderListRepo() {
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order getSingle(String id) {
        return this.orders.stream().filter(order -> order.id().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Set<Order> getAll() {
        return orders;
    }

    @Override
    public void add(Order order) {
        this.orders.add(order);
    }

    @Override
    public void remove(String id) {
        Order order = this.getSingle(id);
        this.orders.remove(order);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
