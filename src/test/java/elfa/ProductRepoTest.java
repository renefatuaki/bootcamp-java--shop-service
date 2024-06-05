package elfa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;


class ProductRepoTest {
    Product jacket;
    Product pants;
    Product shoes;

    ProductRepo productRepo;

    @BeforeEach
    void setUp() {
        jacket = new Product(Utility.createUUID(), "Jacket", new BigDecimal("99.90"));
        pants = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));
        shoes = new Product(Utility.createUUID(), "Pants", new BigDecimal("99.90"));
        productRepo = new ProductRepo();
        productRepo.add(jacket);
        productRepo.add(pants);
    }

    @Test
    void getProductByName_whenSearchByWordJacket_returnProductOfJacket() {
        Product product = productRepo.getProductByName("Jacket");
        assertEquals(jacket, product);
    }

    @Test
    void getProductByName_whenSearchByNotExistingProductName_returnNull() {
        Product product = productRepo.getProductByName("WrongProductName");
        assertNull(product);
    }


    @Test
    void getProductById_whenSearchByIdOfProductJacket_returnProductOfJacket() {
        Product product = productRepo.getProductById(jacket.id());
        assertEquals(jacket, product);
    }

    @Test
    void getProductById_whenSearchByNotExistingProductId_returnNull() {
        Product product = productRepo.getProductById("0001");
        assertNull(product);
    }

    @Test
    void add() {
        int prevSize = productRepo.getProducts().size();
        productRepo.add(shoes);
        int newSize = productRepo.getProducts().size();
        assertEquals(prevSize + 1, newSize);
        assertTrue(productRepo.getProducts().contains(shoes));
    }

    @Test
    void remove() {
        int prevSize = productRepo.getProducts().size();
        productRepo.remove(jacket);
        int newSize = productRepo.getProducts().size();
        assertEquals(prevSize - 1, newSize);
        assertFalse(productRepo.getProducts().contains(jacket));
    }
}