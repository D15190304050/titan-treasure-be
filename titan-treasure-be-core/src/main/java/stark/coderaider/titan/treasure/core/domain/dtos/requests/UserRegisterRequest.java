package stark.coderaider.titan.treasure.core.domain.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
public class UserRegisterRequest
{
    @NotBlank(message = "Avatar URL cannot be blank.")
    @Size(max = 255, message = "Avatar URL cannot be longer than 255 characters.")
    private String avatarUrl;

    @NotBlank(message = "Username cannot be blank.")
    @Size(max = 64, message = "Username cannot be longer than 64 characters.")
    private String username;

    @NotBlank(message = "Nickname cannot be blank.")
    @Size(max = 50, message = "Nickname cannot be longer than 50 characters.")
    private String nickname;

    @NotBlank(message = "Email cannot be blank.")
    @Size(max = 64, message = "Email cannot be longer than 64 characters.")
    @Email(message = "Email is not valid.")
    private String email;

    @NotBlank(message = "Password cannot be blank.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+={}\\[\\]:;\"'<>,.?/~`-]).{8,20}$", message = "Password must contain at least one letter, one number, one special character, and be between 8 and 20 characters long.")
    private String password;

    @NotBlank(message = "Phone number cannot be blank.")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "Phone number is not valid.")
    private String phoneNumber;

    @Range(min = 0, max = 2, message = "Gender must be between 0 and 2.")
    private Integer gender;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private Date birthday;

    @Size(max = 255, message = "Bio cannot be longer than 255 characters.")
    private String bio;
}
