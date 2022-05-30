package ru.ssau.stroimvmeste2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.ssau.stroimvmeste2.model.District;
import ru.ssau.stroimvmeste2.model.User;
import ru.ssau.stroimvmeste2.service.DistrictService;
import ru.ssau.stroimvmeste2.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserJspController {

    private final UserService userService;
    private final DistrictService districtService;

    @GetMapping("/all")
    public String viewUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUserView(Model model) {
        model.addAttribute("user", new User());
        List<District> districts = districtService.getAllDistricts();
        model.addAttribute("districts", districts);
        return "add-user";
    }

    @PostMapping("/addUser")
    public RedirectView addUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("all", true);
        User savedUser = userService.addUser(user);
        redirectAttributes.addFlashAttribute("savedUser", savedUser);
        redirectAttributes.addFlashAttribute("addUserSuccess", true);
        return redirectView;
    }

    @GetMapping("/updateUser/{id}")
    public String updateUserView(Model model, @PathVariable Integer id) {
        model.addAttribute("user", userService.getUser(id));
        return "update-user";
    }

    @PostMapping("/updateUser")
    public RedirectView updateUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("all", true);
        User updatedUser = userService.updateUser(user);
        redirectAttributes.addFlashAttribute("updatedUser", updatedUser);
        redirectAttributes.addFlashAttribute("updateUserSuccess", true);
        return redirectView;
    }
    @GetMapping("/deleteUser/{id}")
    public RedirectView deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        final RedirectView redirectDeleteView = new RedirectView("/users/all", true);
        return redirectDeleteView;
    }



}
