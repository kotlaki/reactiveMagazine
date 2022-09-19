package ru.kurganov.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.kurganov.config.ApplicationConstraint;
import ru.kurganov.domain.Category;
import ru.kurganov.domain.Product;
import ru.kurganov.repo.CategoriesRepository;
import ru.kurganov.service.ProductService;
import java.util.Map;
import java.util.Objects;

import static ru.kurganov.config.ApplicationConstraint.FULL_DESCRIPTION;
import static ru.kurganov.config.ApplicationConstraint.PRICE;
import static ru.kurganov.config.ApplicationConstraint.PRODUCT_ID;
import static ru.kurganov.config.ApplicationConstraint.SHORT_DESCRIPTION;
import static ru.kurganov.config.ApplicationConstraint.TITLE;
import static ru.kurganov.config.ApplicationConstraint.VENDOR_CODE;

@Slf4j
@Component
@AllArgsConstructor
public class ProductsHandler {

    private final ProductService productService;

    private final CategoriesRepository categoriesRepository;
    public Mono<ServerResponse> catalog(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .render("shop-page", Map.of("products", productService.findAll()));
    }

    public Mono<ServerResponse> showProduct(ServerRequest serverRequest) {
        Mono<Product> product = productService.findById(Long.parseLong(serverRequest.pathVariable("id")));
        Flux<Category> categories = categoriesRepository.findAll();
        return ServerResponse
                .ok()
                .render("edit-product", Map.of("product", product, "categories", categories));
    }

    public Mono<ServerResponse> updateProduct(ServerRequest serverRequest) {
        Mono<Product> product = serverRequest.bodyToMono(Product.class)
                .flatMap(productService::update);
//        Mono<Product> product = serverRequest.formData()
//                                                 .map(this::formDataToEntity)
//                                                 .flatMap(productService::update);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .render("shop-page", Map.of("product", product, "products", productService.findAll()));
    }

    private Product formDataToEntity(MultiValueMap<String, String> formData) {
        Product product = new Product();
        product.setId(Long.parseLong(Objects.requireNonNull(formData.getFirst(PRODUCT_ID))));
        product.setVendorCode(formData.getFirst(VENDOR_CODE));
        product.setFullDescription(formData.getFirst(FULL_DESCRIPTION));
        product.setShortDescription(formData.getFirst(SHORT_DESCRIPTION));
        product.setTitle(formData.getFirst(TITLE));
        product.setPrice(Double.parseDouble(Objects.requireNonNull(formData.getFirst(PRICE))));
        Category category = new Category();
        category.setTitle("Ноутбук");
        category.setId(1L);
        product.setCategory(category);
//        product.setCategory(formData.getFirst());
        return product;
    }
}
