package ru.kurganov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.kurganov.domain.entity.Users;

@Repository
public interface UserRepositories extends ReactiveCrudRepository<Users, Long> {

    Users findByEmail(String email);
//
//    Page<Users> findAll(Pageable pageable);
}
