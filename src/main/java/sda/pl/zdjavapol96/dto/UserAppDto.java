package sda.pl.zdjavapol96.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserAppDto {
    @NotNull
    @Length(min = 3, max = 25, message = "Username must be 3 to 25 characters long")
    private String username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
