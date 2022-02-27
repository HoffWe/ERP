package sda.pl.zdjavapol96.exception;

import java.math.BigDecimal;

public class NotEnoughProductOnStock extends RuntimeException{
    private final BigDecimal quantity;
    public NotEnoughProductOnStock(String message,BigDecimal quantity) {
        super(message);
        this.quantity = quantity;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
