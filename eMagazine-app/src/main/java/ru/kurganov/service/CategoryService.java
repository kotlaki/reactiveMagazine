package ru.kurganov.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Category;

public interface CategoryService {
    Flux<Category> findAll();
    Mono<Category> findById(Long id);
}
