package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaProductService implements ProductService{
    private final ProductRepository productRepository;

    public JpaProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(ProductDto newProduct) {
        Product product = Product.builder()
                .productName(newProduct.getProductName())
                .isSaleable(newProduct.isSaleable())
                .quantity(newProduct.getQuantity())
                .unit(newProduct.getUnit())
                .vat(newProduct.getVat())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id){
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
