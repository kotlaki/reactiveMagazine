package ru.kurganov.domain.dto;

import lombok.Data;
import ru.kurganov.domain.UserRole;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Collection;

@Data
public class UserDto {

    private Long id;

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    private String matchingPassword;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String middleName;

    @NotEmpty
    private String phone;

    private UserRole role;

    private boolean active;

    private LocalDate createDate;

    public UserDto() {
    }

    public UserDto(Long id,
                   String email,
                   String password,
                   String firstName,
                   String lastName,
                   String middleName,
                   String phone,
                   UserRole roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.role = roles;
    }
}
