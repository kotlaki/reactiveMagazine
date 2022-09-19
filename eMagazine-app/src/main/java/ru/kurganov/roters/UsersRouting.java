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
    public RouterFunction<ServerResponse> routes(UsersHandler usersHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/"), usersHandler::index)
                .andRoute(RequestPredicates.GET("/allUsers"), usersHandler::allUsers)
                .andRoute(RequestPredicates.GET("/registration"), usersHandler::registration)
                .andRoute(RequestPredicates.POST("/registration")
                                           .and(RequestPredicates.accept(MediaType.APPLICATION_FORM_URLENCODED)), usersHandler::save)
                .andRoute(RequestPredicates.GET("/allUsers/edit/{id}"), usersHandler::formUpdate)
                .andRoute(RequestPredicates.POST("/allUsers/update/{id}"), usersHandler::update)
                .andRoute(RequestPredicates.GET("/allUsers/delete/{id}"), usersHandler::delete);
    }
}
