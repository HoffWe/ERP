package sda.pl.zdjavapol96.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documentElements")
public class DocumentElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(targetEntity = Document.class)
    private Document document;
    @ManyToOne(targetEntity = Product.class)
    private Product product;
    @Column(nullable = false, length = 20)
    private BigDecimal quantity;
    @ManyToOne(targetEntity = ProductPrice.class)
    private ProductPrice productPrice;
}