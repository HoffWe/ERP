package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
public class CustomerDto {
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9'.\\-\\s,]")
    @Length(min = 3, message = "Name must be at least 3 characters long")
    private String name;
    @NotNull
    @Pattern(regexp = "^([A-Z][a-z]*)+(?:[\\s-][A-Z][a-zA-Z]*)*$", message = " Country name must be correct")
    private String country;
    @NotNull
    @Pattern(regexp = "[A-Za-z0-9'.\\-\\s,]")
    private String address;
    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?^(\\d{3}[- .]?){2}\\d{4}$", message = "Phone number must be correct")
    private long phoneNumber;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "E-mail must be correct")
    private String eMail;
    private String taxId;
}
