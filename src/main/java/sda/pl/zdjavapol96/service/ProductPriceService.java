package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.ProductPrice;

import java.util.List;
import java.util.Optional;


public interface ProductPriceService {
    ProductPrice add(ProductPriceDto newProductPrice);
    List<ProductPrice> findAll();
    Optional<ProductPrice> findById(long id);
    void deleteById(long id);


}
