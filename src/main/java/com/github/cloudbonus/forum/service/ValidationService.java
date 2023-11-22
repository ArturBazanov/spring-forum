package com.github.cloudbonus.forum.service;

import com.github.cloudbonus.forum.model.User;
import com.github.cloudbonus.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidationService {
    private final UserRepository userRepository;
    @Autowired
    public ValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findUser(String username) {
        return userRepository.findByEmailIgnoreCase(username);
    }
}
