package ru.kurganov.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.kurganov.domain.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product,Long> {

}
