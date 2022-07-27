package ru.kurganov.controllers.impl;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import ru.kurganov.controllers.UsersApi;
import ru.kurganov.services.UserService;

@Controller
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersApi {

    private final UserService userService;

    @Override
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers",  userService.findAll());
        return "users-list";
    }
}
