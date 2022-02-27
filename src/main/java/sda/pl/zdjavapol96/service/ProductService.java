package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product add(ProductDto newProduct);
    List<Product> findAll();
    Optional<Product> findById(long id);
    void deleteById(long id);

}
