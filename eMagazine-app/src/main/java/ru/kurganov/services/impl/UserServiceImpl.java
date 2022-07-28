package ru.kurganov.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.domain.entity.Users;
import ru.kurganov.domain.entity.enums.Role;
import ru.kurganov.exceptions.LoginAlreadyExistException;
import ru.kurganov.services.UserRepositories;
import ru.kurganov.services.UserService;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    private final PasswordEncoder passwordEncoder;

//    private final RoleRepositories roleRepositories;

//    @Override
//    public User findByUserName(String username) {
//        return userRepositories.findOneByUserName(username);
//    }

//    @Override
//    @Transactional
//    public boolean createUser(UserDto userDto) {
//        if (!Objects.isNull(userRepositories.findByEmail(userDto.getEmail()))) {
//            throw LoginAlreadyExistException.byUserName(userDto.getEmail());
//        }
//        Users users = new Users();
//                        users.setEmail(userDto.getEmail());
//                        users.setPassword(passwordEncoder.encode(userDto.getPassword()));
//                        users.setLastName(userDto.getLastName());
//                        users.setFirstName(userDto.getFirstName());
//                        users.setMiddleName(userDto.getMiddleName());
//                        users.setPhone(userDto.getPhone());
//                        users.setActive(true);
//                        users.setCreateDate(LocalDateTime.now());
//                        users.setRoles(Set.of(Role.ROLE_USER));
//
//        userRepositories.save(users);
//        log.info("Пользователь {} сохранен в БД!", userDto.getEmail());
//        return true;
//    }

    @Override
    public boolean saveUser(Users users) {
        return false;
    }

//    @Override
//    public List<Users> findAll() {
//        return userRepositories.findAll();
//    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return null;
    }

    @Override
    public Page<Users> getUsersWithPagingAndFiltering(int pageNumber,
                                                      int pageSize,
                                                      Specification<Users> userSpecification) {
        return null;
    }

//    @Override
//    public Optional<Users> findById(Long id) {
//        return Optional.of(userRepositories.findById(id))
//                       .orElseThrow(() -> LoginAlreadyExistException.byUserName(id.toString()));
//    }

    @Override
    public void deleteById(Long id) {
        userRepositories.deleteById(id);
    }
}
