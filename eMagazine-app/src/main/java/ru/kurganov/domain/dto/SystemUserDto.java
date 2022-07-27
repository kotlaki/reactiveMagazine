package ru.kurganov.domain.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class SystemUserDto implements Serializable {
    @NotNull(message = "not null check")
    @Size(min = 3, message = "login length must be greater than 2 symbols")
    private String login;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String middleName;

    @NotNull(message = "is required")
    @Email
    private String email;

    @NotNull(message = "is required")
    @Size(min = 12, message = "is required")
    private String phone;
}
