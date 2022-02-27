package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;

public class ProductMapper {
    static public ProductDto mapToDto(Product product){
        return ProductDto.builder()
                .productName(product.getProductName())
                .unit(product.getUnit())
                .quantity(product.getQuantity())
                .vat(product.getVat())
                .build();
    }
}
