package ru.ssau.stroimvmeste2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ssau.stroimvmeste2.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserJspController {

    private final UserService userService;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("districts", userService.getAllUsers());
        return "users";
    }
}
