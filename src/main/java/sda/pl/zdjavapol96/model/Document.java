package sda.pl.zdjavapol96.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documents")
@Getter
@Setter
@ToString
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private DocumentType documentType;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @Column(nullable = false)
    @OneToMany(
            mappedBy = "document",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private Set<DocumentElement> documentElements = new HashSet<>();
    @Column(nullable = false)
    private LocalDate issueDate;
    @ManyToOne(targetEntity = UserApp.class)
    private UserApp user;
    @Column(name = "totalnet")
    private BigDecimal totalNet;
    @Column(name = "totalgros")
    private BigDecimal totalGros;
    @Column(name = "accepted")
    private Boolean accepted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id && documentType == document.documentType && Objects.equals(customer, document.customer) && Objects.equals(issueDate, document.issueDate) && Objects.equals(user, document.user) && Objects.equals(totalNet, document.totalNet) && Objects.equals(totalGros, document.totalGros) && Objects.equals(accepted, document.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentType, customer, issueDate, user, totalNet, totalGros, accepted);
    }
}
