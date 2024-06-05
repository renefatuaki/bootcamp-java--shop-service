package elfa;

//Step 1: Create an OrderRepo interface with the methods from the OrderListRepo (add, remove, and getSingle, getAll).

import java.util.Set;

public interface OrderRepo {
    Order getSingle(String id);

    Set<Order> getAll();

    void add(Order order);

    void remove(String id);
}
