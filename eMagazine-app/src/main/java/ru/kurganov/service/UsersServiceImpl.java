package ru.kurganov.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.UserRole;
import ru.kurganov.domain.Users;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.exceptions.UserAlreadyExistException;
import ru.kurganov.repo.UserRepository;
import java.time.LocalDate;

@Slf4j
@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
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
    @Transactional
    public Mono<Users> save(UserDto userDto) {
        Users user = prepareUser(userDto);
        return userRepository.save(user)
                .onErrorResume(k ->
                        Mono.error(UserAlreadyExistException.userAlreadyExistByName(user.getEmail())));
    }

    private Users prepareUser(UserDto userDto) {
        Users user = new Users();
        modelMapper.map(userDto, user);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(UserRole.ROLE_USER);
        user.setActive(true);
        user.setCreateDate(LocalDate.now());
        return user;
    }
}
