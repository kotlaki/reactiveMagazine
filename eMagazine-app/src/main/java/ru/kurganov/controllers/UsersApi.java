package ru.kurganov.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Api(value = "users")
public interface UsersApi {

//    @ApiOperation(value = "Список пользователей", response = String.class, tags = "users")
//    @ApiResponses(value = {
//            @ApiResponse(code = SC_OK, message = "вывод списка пользователей", response = List.class),
//            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Внутренняя ошибка обработки запроса", response = String.class)
//    })
//    @GetMapping("/users")
//    String getAllUsers(Model model);
}
