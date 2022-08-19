package ru.kurganov.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Product;
import ru.kurganov.domain.dto.ProductDto;

public interface ProductService {

    Flux<Product> findAll();

    Mono<Product> save(ProductDto productDto);

}
