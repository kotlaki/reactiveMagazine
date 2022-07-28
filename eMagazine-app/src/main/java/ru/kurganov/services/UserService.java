package ru.kurganov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.domain.entity.Users;
import ru.kurganov.domain.entity.enums.Role;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserService extends UserDetailsService {
//    User findByUserName(String username);

//    boolean createUser(UserDto userDto);

    boolean saveUser(Users users);

//    List<Users> findAll();

    UserDetails loadUserByUsername(String userName);

    Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);

    public Page<Users> getUsersWithPagingAndFiltering(int pageNumber, int pageSize,
                                                      Specification<Users> userSpecification);


    //    List<User> findAllUser();
    //
//    Optional<Users> findById(Long id);

    void deleteById(Long id);
}
