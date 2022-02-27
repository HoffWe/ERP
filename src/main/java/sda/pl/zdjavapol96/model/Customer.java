package sda.pl.zdjavapol96.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(nullable = false ,length = 100)
        private String name;
        @Column(nullable = false,length = 20)
        private String country;
        @Column(nullable = false,length = 100)
        private String address;
        @Column(nullable = false,length = 15)
        private long phoneNumber;
        @Column(length = 30)
        private String eMail;
        @Column(length = 15, unique = true)
        private String taxId;
}
