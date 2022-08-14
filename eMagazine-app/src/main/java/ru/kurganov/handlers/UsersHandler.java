package ru.kurganov.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.service.UsersService;
import java.util.Map;

import static ru.kurganov.config.ApplicationConstraint.*;

@Slf4j
@Component
@AllArgsConstructor
public class UsersHandler {

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
                .render("/registration", Map.of("userDto", UserDto.builder().build()));
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Users> multi = serverRequest.formData()
                                         .map(this::formDataToEmployee)
                                         .flatMap(usersService::save)
                                         .cast(Users.class);
        return ServerResponse
                .ok()
                .render("registration-confirmation", multi, UserDto.class);
    }

    private UserDto formDataToEmployee(MultiValueMap<String, String> formData) {
        return UserDto.builder()
                      .email(formData.getFirst(EMAIL))
                      .lastName(formData.getFirst(LAST_NAME))
                      .firstName(formData.getFirst(FIRST_NAME))
                      .middleName(formData.getFirst(MIDDLE_NAME))
                      .password(formData.getFirst(PASSWORD))
                      .phone(formData.getFirst(PHONE))
                      .build();
    }
}
