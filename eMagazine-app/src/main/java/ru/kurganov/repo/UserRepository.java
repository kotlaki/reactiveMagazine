package ru.kurganov.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Long>{
     Mono<Users> findUsersByEmail(String name);

     @Query("select * from users where id = :id")
     Mono<Users> findById(Long id);
}
