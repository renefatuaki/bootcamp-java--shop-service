package elfa;

//Step 1: Implement a method to place a new order.
//Step 2: Check if the ordered products exist. If not, print a System.out.println message.

import java.time.LocalDateTime;

public class ShopService {
    public static Order addOrder(Product product, int quantity) {
        return new Order(product.id(), product, quantity, LocalDateTime.now());
    }

    public static boolean isProduct(ProductRepo productRepo, String name) {
        Product productResult = productRepo.getProducts().stream().filter(product -> product.name().equals(name)).findFirst().orElse(null);
        return productResult != null;
    }
}
