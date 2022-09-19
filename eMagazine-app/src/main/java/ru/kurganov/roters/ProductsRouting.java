package ru.kurganov.roters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.kurganov.handlers.ProductsHandler;

@Configuration
public class ProductsRouting {

    @Bean
    public RouterFunction<ServerResponse> catalog(ProductsHandler productsHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/shop"), productsHandler::catalog)
                .andRoute(RequestPredicates.GET("/shop/edit/{id}"), productsHandler::showProduct)
                .andRoute(RequestPredicates.POST("/shop/update"), productsHandler::updateProduct);
    }
}
