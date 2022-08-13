package ru.kurganov.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.UserRole;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.service.UsersService;
import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class IndexHandler {

    private final UsersService usersService;

    public Mono<ServerResponse> index(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .render("index");
    }

    public Mono<ServerResponse> allUsers(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .render("users-list", Map.of("listUsers", usersService.findAll()));
    }

    public Mono<ServerResponse> registration(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .render("/registration", Map.of("userDto", new UserDto()));
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {

        Mono<Users> multi = serverRequest.formData()
                                         .map(this::formDataToEmployee)
                                         .flatMap(usersService::save).cast(Users.class);
        return ServerResponse
                .ok()
                .render("registration-confirmation", multi, UserDto.class);
    }

    private UserDto formDataToEmployee(MultiValueMap<String, String> formData) {
        UserDto userDto = new UserDto();
        userDto.setEmail(formData.getFirst("email"));
        userDto.setLastName(formData.getFirst("lastName"));
        userDto.setFirstName(formData.getFirst("firstName"));
        userDto.setMiddleName(formData.getFirst("middleName"));
        userDto.setPhone(formData.getFirst("phone"));
        userDto.setPassword(formData.getFirst("password"));
        userDto.setRole(UserRole.ROLE_USER);
        userDto.setActive(true);
        userDto.setCreateDate(LocalDate.now());
        return userDto;
    }
}
