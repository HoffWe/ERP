package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ProductPriceDto {
    @NotNull
    private BigDecimal purchasePrice;
    @NotNull
    private BigDecimal sellingPrice;
    @NotNull
    private LocalDate introductionDate;
    @NotNull
    private long productId;
}
