package elfa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Order(String id, Product product, int quantity, LocalDateTime date) {
    public BigDecimal totalPrice() {
        return product().price().multiply(BigDecimal.valueOf(quantity));
    }

    public Order changeQuantity(int newQuantity) {
        return new Order(this.id, this.product, newQuantity, this.date);
    }
}
