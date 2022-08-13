package ru.kurganov.roters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.kurganov.handlers.IndexHandler;

@Configuration
public class UsersRouting {

    @Bean
    public RouterFunction<ServerResponse> index(IndexHandler indexHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/")
                                 .and(RequestPredicates.accept(MediaType.TEXT_HTML)),
                indexHandler::index
        );
    }

    @Bean
    public RouterFunction<ServerResponse> allUsers(IndexHandler indexHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/allUsers"),
                indexHandler::allUsers
        );
    }

    @Bean
    public RouterFunction<ServerResponse> registration(IndexHandler indexHandler) {
        return RouterFunctions.route()
                              .GET(
                                      "/registration",
                                      indexHandler::registration
                              )
                              .POST(
                                      "/registration",
                                      RequestPredicates.accept(MediaType.APPLICATION_FORM_URLENCODED),
                                      indexHandler::save
                              )
                              .build();
    }
}
