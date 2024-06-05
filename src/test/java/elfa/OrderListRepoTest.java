package elfa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {
    Product jacket;
    Product pants;
    Product shoes;

    Order firstOrder;
    Order secondOrder;
    Order thirdOrder;

    Set<Order> orders;

    OrderListRepo orderList;

    @BeforeEach
    void setUp() {
        jacket = new Product(Utility.createUUID(), "Jacket", new BigDecimal("99.90"));
        pants = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));
        shoes = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));

        firstOrder = new Order("0001", jacket, 5, LocalDateTime.now());
        secondOrder = new Order(Utility.createUUID(), pants, 2, LocalDateTime.now());
        thirdOrder = new Order(Utility.createUUID(), shoes, 1, LocalDateTime.now());

        orders = new HashSet<>();
        orders.add(firstOrder);
        orders.add(secondOrder);
        orderList = new OrderListRepo(orders);
    }

    @Test
    void getSingle_returnFirstOrder_whenIdIs0001() {
        Order order = orderList.getSingle("0001");
        assertEquals(order, firstOrder);
    }

    @Test
    void getSingle_returnNull_whenIdNotExist() {
        Order order = orderList.getSingle("9999");
        assertNull(order);
    }

    @Test
    void getAll() {
        Set<Order> allOrders = orderList.getAll();
        assertEquals(orders, allOrders);
    }

    @Test
    void add() {
        int prevSize = orderList.getOrders().size();
        orderList.add(thirdOrder);
        int newSize = orderList.getOrders().size();
        assertEquals(prevSize + 1, newSize);
    }

    @Test
    void remove() {
        int prevSize = orderList.getOrders().size();
        orderList.remove("0001");
        int newSize = orderList.getOrders().size();
        assertEquals(prevSize - 1, newSize);
    }
}