package sda.pl.zdjavapol96.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50,nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false,length = 50, unique = true)
    private String productName;
    @Column(nullable = false)
    private Boolean isSaleable;
    @Column(nullable = false, length = 25)
    private String unit;
    @Column(nullable = false,length = 15)
    private BigDecimal vat;
}
