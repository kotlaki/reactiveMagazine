package ru.kurganov.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String matchingPassword;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String middleName;

    @NotEmpty
    private String phone;
}
