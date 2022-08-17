package ru.kurganov.roters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import ru.kurganov.handlers.UsersHandler;

@Configuration
public class UsersRouting {

    @Bean
    public RouterFunction<ServerResponse> index(UsersHandler usersHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/")
                                 .and(RequestPredicates.accept(MediaType.TEXT_HTML)),
                usersHandler::index
        );
    }

    @Bean
    public RouterFunction<ServerResponse> allUsers(UsersHandler usersHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/allUsers"),
                usersHandler::allUsers
        );
    }

    @Bean
    public RouterFunction<ServerResponse> registration(UsersHandler usersHandler) {
        return RouterFunctions.route()
                              .GET(
                                      "/registration",
                                      usersHandler::registration
                              )
                              .POST(
                                      "/registration",
                                      RequestPredicates.accept(MediaType.APPLICATION_FORM_URLENCODED),
                                      usersHandler::save
                              )
                              .build();
    }

    @Bean
    public RouterFunction<ServerResponse> update(UsersHandler usersHandler) {
        return RouterFunctions.route()
                .GET("/allUsers/edit/{id}",
                        usersHandler::formUpdate)
                .POST("/allUsers/update/{id}",
                        usersHandler::update)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> delete(UsersHandler usersHandler) {
        return RouterFunctions.route()
                .GET("/allUsers/delete/{id}",
                        usersHandler::delete)
                .build();
    }
}
