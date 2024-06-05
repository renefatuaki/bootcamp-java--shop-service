package elfa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    Product jacket;
    Product pants;
    Product shoes;

    Order firstOrder;
    Order secondOrder;
    Order thirdOrder;

    ProductRepo productList;

    @BeforeEach
    void setUp() {
        jacket = new Product(Utility.createUUID(), "Jacket", new BigDecimal("99.90"));
        pants = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));
        shoes = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));

        productList = new ProductRepo();
        productList.add(jacket);
        productList.add(pants);
        productList.add(shoes);

        firstOrder = new Order("0001", jacket, 5, LocalDateTime.now());
        secondOrder = new Order(Utility.createUUID(), pants, 2, LocalDateTime.now());
        thirdOrder = new Order(Utility.createUUID(), shoes, 1, LocalDateTime.now());
    }

    @Test
    void addOrder() {
        Order order = ShopService.addOrder(jacket, 10);
        assertTrue(order instanceof Order);
    }

    @Test
    void isProduct_whenExistingProductExist_returnTrue() {
        boolean isProduct = ShopService.isProduct(productList, "Jacket");
        assertTrue(isProduct);
    }

    @Test
    void isProduct_whenNotExistingProduct_returnFalse() {
        boolean isProduct = ShopService.isProduct(productList, "NoExistingProduct");
        assertFalse(isProduct);
    }
}