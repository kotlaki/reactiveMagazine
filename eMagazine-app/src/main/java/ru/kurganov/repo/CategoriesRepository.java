package ru.kurganov.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.kurganov.domain.Category;

public interface CategoriesRepository extends ReactiveCrudRepository<Category, Long> {
}
