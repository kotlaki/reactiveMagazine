package ru.kurganov.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kurganov.domain.dto.UserDto;
import javax.validation.Valid;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_OK;

/**
 * Описание API для регистрации пользователей
 *
 * @author Roman Kurganov
 **/
@Api(value = "registration")
public interface RegistrationApi {

    @ApiOperation(value = "Регистрация нового пользователя", response = String.class, tags = "registration")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Успешное сохранение пользователя в БД", response = String.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Внутренняя ошибка обработки запроса", response = String.class)
    })
    @GetMapping("/registration")
    String registration(Model model);

    @ApiOperation(value = "Регистрация нового пользователя", response = String.class, tags = "registration")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Успешное сохранение пользователя в БД", response = String.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Внутренняя ошибка обработки запроса", response = String.class)
    })
    @PostMapping("/registration")
    String createUser(@Valid @ModelAttribute("userDto") UserDto userDto, Model model, BindingResult bindingResult);

    @ApiOperation(value = "Авторизация пользователя", response = String.class, tags = "login")
    @ApiResponses(value = {
            @ApiResponse(code = SC_OK, message = "Успешная авторизация пользователя", response = String.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Внутренняя ошибка обработки запроса", response = String.class)
    })
    @GetMapping("/login")
    String login();
}
