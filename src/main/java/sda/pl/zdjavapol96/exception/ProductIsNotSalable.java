package sda.pl.zdjavapol96.exception;

public class ProductIsNotSalable extends RuntimeException {
    private final long productId;

    public ProductIsNotSalable(String message, long productId) {
        super(message);
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
