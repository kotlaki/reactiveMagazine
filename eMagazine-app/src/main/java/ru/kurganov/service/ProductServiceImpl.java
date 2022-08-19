package ru.kurganov.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Product;
import ru.kurganov.domain.dto.ProductDto;
import ru.kurganov.repo.ProductRepository;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Mono<Product> save(ProductDto productDto) {
        return null;
    }
}
