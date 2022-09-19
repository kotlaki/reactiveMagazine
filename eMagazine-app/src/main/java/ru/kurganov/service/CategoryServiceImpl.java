package ru.kurganov.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.domain.Category;
import ru.kurganov.repo.CategoriesRepository;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoriesRepository categoriesRepository;

    @Override
    public Flux<Category> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Mono<Category> findById(Long id) {
        return categoriesRepository.findById(id);
    }
}
