package ru.kurganov.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;

public interface UsersService extends ReactiveUserDetailsService {
    Mono<UserDetails> findByUsername(String username);

    Flux<Users> findAll();

    Mono<Users> findByUserName(String username);

    Mono<Users> save(UserDto userDto);
}
