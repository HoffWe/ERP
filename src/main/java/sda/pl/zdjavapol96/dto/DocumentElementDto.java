package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class DocumentElementDto {
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private long productPriceId;
    @NotNull
    private long productId;
    @NotNull
    private long documentId;
}
