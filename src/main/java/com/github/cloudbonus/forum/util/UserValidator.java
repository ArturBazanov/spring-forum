package com.github.cloudbonus.forum.util;

import com.github.cloudbonus.forum.model.User;
import com.github.cloudbonus.forum.service.RegistrationService;
import com.github.cloudbonus.forum.service.UserDetailsServiceImpl;
import com.github.cloudbonus.forum.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {

    private final ValidationService validationService;
    @Autowired
    public UserValidator(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        Optional<User> result = validationService.findUser(user.getUsername());
        if (result.isEmpty()) return;
        errors.rejectValue("username", "", "A user with this name already exists.");
    }
}
