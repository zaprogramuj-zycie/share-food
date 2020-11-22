package pl.zz.sharefood.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @NotEmpty
    @NotNull
    private String name;
    private String firstname;
    private String lastname;
    @NotEmpty
    @NotNull
    @Email(message = "Invalid email")
    private String email;
    @NotEmpty
    @NotNull
    @Length(min = 6, max = 15, message = "Invalid length password")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>-]).{6,15}")
    private String password;
    private Date createdAt;
}
