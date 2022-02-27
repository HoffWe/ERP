package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.repository.ProductPriceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaProductPriceService implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public JpaProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }
    @Override
    public ProductPrice add(ProductPriceDto newProductPrice) {
        ProductPrice productPrice = ProductPrice.builder()
                .product(Product.builder()
                        .id(newProductPrice.getProductId())
                        .build())
                .purchasePrice(newProductPrice.getPurchasePrice())
                .sellingPrice(newProductPrice.getSellingPrice())
                .introductionDate(newProductPrice.getIntroductionDate())
                .build();
        return productPriceRepository.save(productPrice);

    }

    @Override
    public List<ProductPrice> findAll() {
        return productPriceRepository.findAll();
    }

    @Override
    public Optional<ProductPrice> findById(long id) {
        return productPriceRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        productPriceRepository.deleteById(id);
    }
}
