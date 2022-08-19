package ru.kurganov.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.kurganov.service.ProductService;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class ProductsHandler {

    private final ProductService productService;

    public Mono<ServerResponse> catalog(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .render("shop-page", Map.of("products", productService.findAll()));
    }

}
