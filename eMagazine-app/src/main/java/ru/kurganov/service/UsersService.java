package ru.kurganov.service;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public interface UsersService extends ReactiveUserDetailsService {
    Mono<UserDetails> findByUsername(String username);
}
