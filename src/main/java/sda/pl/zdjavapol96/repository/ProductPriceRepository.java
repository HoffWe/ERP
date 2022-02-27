package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.zdjavapol96.model.ProductPrice;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
    List<ProductPrice> findProductPricesByProductId(long id);
}
