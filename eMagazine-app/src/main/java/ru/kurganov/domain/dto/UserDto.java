package ru.kurganov.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.kurganov.domain.UserRole;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

@Data
@Builder
public class UserDto implements Serializable {

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

}
