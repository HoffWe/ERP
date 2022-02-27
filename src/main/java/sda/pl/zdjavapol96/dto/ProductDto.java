package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    @NotNull
    @Length(min = 3, message = "Name must be at least 3 characters long")
    private String productName;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private String unit;
    @NotNull
    private BigDecimal vat;
    private boolean isSaleable;
}
