package sda.pl.zdjavapol96.mapper;

import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.ProductPrice;

public class ProductPriceMapper {
    static public ProductPriceDto mapToDto(ProductPrice productPrice){
        return ProductPriceDto.builder()
                .productId(productPrice.getProduct().getId())
                .purchasePrice(productPrice.getPurchasePrice())
                .sellingPrice(productPrice.getSellingPrice())
                .introductionDate(productPrice.getIntroductionDate())
                .build();
    }
}
