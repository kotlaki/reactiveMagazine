package ru.kurganov.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Product;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> findById(Long id);

    Mono<Product> save(Product productDto);

    Mono<Product> update(Product product);
}
