package sda.pl.zdjavapol96;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sda.pl.zdjavapol96.dto.*;
import sda.pl.zdjavapol96.model.DocumentType;
import sda.pl.zdjavapol96.model.UserApp;
import sda.pl.zdjavapol96.repository.UserAppRepository;
import sda.pl.zdjavapol96.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@SpringBootApplication
public class EndProjectWarehouseManagementSystemApplication implements CommandLineRunner {
    private final UserAppRepository userAppRepository;
    private final CustomerService customerService;
    private final ProductService productService;
    private final ProductPriceService productPriceService;
    private final DocumentElementService documentElementService;
    private final DocumentService documentService;


    public EndProjectWarehouseManagementSystemApplication(UserAppRepository userAppRepository,
                                                          CustomerService customerService,
                                                          ProductService productService,
                                                          ProductPriceService productPriceService, DocumentElementService documentElementService, DocumentService documentService){
        this.userAppRepository = userAppRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productPriceService = productPriceService;
        this.documentElementService = documentElementService;
        this.documentService = documentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EndProjectWarehouseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userAppRepository.save(
                UserApp.builder()
                        .username("Arek")
                        .password("1234")
                        .firstName("Arkadiusz")
                        .lastName("Przychocki")
                        .roles("ROLE_ADMIN")
                        .build()
        );
        customerService.add(CustomerDto.builder()
                        .name("Miłosz Transport S.C.")
                        .address("Mazowiecka 12, 00-155 Warszawa")
                        .country("Poland")
                        .eMail("mil-trans@gmail.com")
                        .phoneNumber(888111222)
                        .taxId("PL1875285")
                .build());

        productService.add(ProductDto.builder()
                        .productName("Klucz")
                        .quantity(BigDecimal.valueOf(22))
                        .unit("szt")
                        .vat(BigDecimal.valueOf(23))
                        .isSaleable(true)
                .build());


        productPriceService.add(ProductPriceDto.builder()
                        .purchasePrice(BigDecimal.valueOf(12.23))
                        .sellingPrice(BigDecimal.valueOf(25.00))
                        .introductionDate(LocalDate.of(2022,10,2))
                        .productId(1)
                .build());

        productPriceService.add(ProductPriceDto.builder()
                .purchasePrice(BigDecimal.valueOf(44.23))
                .sellingPrice(BigDecimal.valueOf(56.00))
                .introductionDate(LocalDate.of(2020,10,21))
                .productId(1)
                .build());


        documentService.add(DocumentDto.builder().documentType(DocumentType.PURCHASE_INVOICE)
                .issueDate(LocalDate.of(2020, 11, 21))
                .customerId(1)
                .userId(1)
                .documentElements(Set.of())
                .build());

        documentElementService.add(DocumentElementDto.builder()
                .documentId(1)
                .productId(1)
                .productPriceId(1)
                .quantity(BigDecimal.valueOf(5))
                .build());

        documentService.add(DocumentDto.builder()
                .documentType(DocumentType.GOODS_RECEIVED_NOTE)
                .issueDate(LocalDate.now())
                .customerId(1)
                .userId(1)
                .documentElements(Set.of())
                .build());

        documentElementService.add(DocumentElementDto.builder()
                .documentId(2)
                .productId(1)
                .productPriceId(1)
                .quantity(BigDecimal.valueOf(100))
                .build());

        documentService.add(DocumentDto.builder()
                .documentType(DocumentType.STOCK_ISSUE_CONFIRMATION)
                .userId(1)
                .customerId(1)
                .issueDate(LocalDate.now())
                .documentElements(Set.of())
                .build());

        documentElementService.add(DocumentElementDto.builder()
                        .documentId(3)
                        .quantity(BigDecimal.valueOf(23))
                        .productId(1)
                .build());

        documentService.add(DocumentDto.builder()
                .documentType(DocumentType.SALES_INVOICE)
                .customerId(1)
                .issueDate(LocalDate.of(2019,10,12))
                .documentElements(Set.of())
                .userId(1)
                .build());
        documentElementService.add(DocumentElementDto.builder()
                .productId(1)
                .productPriceId(0)
                .quantity(BigDecimal.valueOf(100))
                .documentId(4)
                .build());




    }

}
