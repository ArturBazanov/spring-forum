package com.github.cloudbonus.forum.service;

import com.github.cloudbonus.forum.security.HttpUserDetails;
import com.github.cloudbonus.forum.model.User;
import com.github.cloudbonus.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HttpUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public HttpUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found " + username);
        }
        return new HttpUserDetails(user.get());
    }
}