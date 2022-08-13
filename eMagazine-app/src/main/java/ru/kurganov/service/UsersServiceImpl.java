package ru.kurganov.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.repo.UserRepository;
import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findUsersByEmail(username).cast(UserDetails.class);
    }

    @Override
    public Flux<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<Users> findByUserName(String username) {
        return userRepository.findUsersByEmail(username);
    }

    @Override
    public Mono<Users> save(UserDto userDto) {
        Users user = new Users();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getLastName());
        user.setMiddleName(userDto.getMiddleName());
        user.setPhone(userDto.getPhone());
        user.setActive(true);
        user.setCreateDate(LocalDate.now());
        user.setRoles(userDto.getRole());
        log.info("Успешное сохранение {}", user.getEmail());
        return userRepository.save(user);
    }
}
