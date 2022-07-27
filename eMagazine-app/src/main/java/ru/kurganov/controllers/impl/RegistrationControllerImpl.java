package ru.kurganov.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.kurganov.controllers.RegistrationApi;
import ru.kurganov.domain.dto.UserDto;
import ru.kurganov.services.UserService;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationControllerImpl implements RegistrationApi {

    private final UserService userService;

    @Override
    public String registration(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @Override
    public String createUser(@Valid @ModelAttribute("userDto") UserDto userDto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage",
                    "Ошибка создания пользователя! Проверте правильность заполнения данных!");
            return "registration";
        }
        if (!userService.createUser(userDto)) {
            model.addAttribute("registrationError",
                    "Ошибка создания пользователя! Пользователь с email "
                            + userDto.getEmail() + " уже существует!");
            return "redirect:/registration";
        }
        return "redirect:/login";
    }

    @Override
    public String login() {
        return "login";
    }

}
