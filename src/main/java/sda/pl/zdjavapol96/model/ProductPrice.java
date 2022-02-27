package sda.pl.zdjavapol96.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productPrices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private BigDecimal purchasePrice;
    @Column(nullable = false)
    private BigDecimal sellingPrice;
    @Column(nullable = false)
    private LocalDate introductionDate;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
}
