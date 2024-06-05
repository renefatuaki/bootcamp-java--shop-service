package elfa;

//Step 1: Create a record Product with the necessary attributes.
//Step 2: Implement the ProductRepo class with a list to store products.
//Step 3: Implement methods to add, remove, and get products (single product and all products).

import java.util.HashSet;
import java.util.Set;

public class ProductRepo {
    Set<Product> products = new HashSet<>();

    public ProductRepo(Set<Product> products) {
        this.products = products;
    }

    public ProductRepo() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        return this.products.stream().filter(product -> product.name().equals(name)).findFirst().orElse(null);
    }

    public Product getProductById(String id) {
        return this.products.stream().filter(product -> product.id().equals(id)).findFirst().orElse(null);
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void remove(Product product) {
        this.products.remove(product);
    }
}
