package com.github.cloudbonus.forum.controller;

import com.github.cloudbonus.forum.model.User;
import com.github.cloudbonus.forum.service.RegistrationService;
import com.github.cloudbonus.forum.util.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserValidator userValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(UserValidator userValidator, RegistrationService registrationService) {
        this.userValidator = userValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        return "auth/signup";
    }
    @PostMapping("/signup")
    public String performSignUp(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) return "/auth/signup";
        registrationService.register(user);
        return "redirect:/auth/login";
    }
}
