package ru.kurganov.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product,Long> {

    @Query("select * from products join categories c on c.id = products.category_id where products.id = :id")
    Mono<Product> findProduct(Long id);

}
