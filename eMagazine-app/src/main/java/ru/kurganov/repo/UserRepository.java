package ru.kurganov.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Users;

@Repository
public interface UserRepository extends ReactiveCrudRepository<Users, Long>{
     Mono<Users> findUsersByEmail(String name);
}
