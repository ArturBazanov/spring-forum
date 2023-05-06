package com.example.myOwnWebApp.controller;

import com.example.myOwnWebApp.model.Message;
import com.example.myOwnWebApp.model.User;
import com.example.myOwnWebApp.repository.MessageRepo;
import com.example.myOwnWebApp.repository.UserRepo;
import com.example.myOwnWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class Default {
    private MessageRepo messageRepo;
    private UserRepo userRepo;
    private ProductService productService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public Default(MessageRepo messageRepo, ProductService productService, UserRepo userRepo) {
        this.messageRepo = messageRepo;
        this.productService = productService;
        this.userRepo = userRepo;
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @GetMapping("/new")
    public String createPage(Model model) {
        return "createUser";
    }
    @PostMapping("/new")
    public String addNewUser(User user, Model model) {
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        List<User> users = userRepo.findAll();
        for (User u :
                users) {
            System.out.println(u.getUsername() + " " + u.getPassword());
        }
        model.addAttribute("users", users);

        return "index";
    }


    @GetMapping("/")
    public String mainPage(Model model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/")
    public String addMessage(@RequestParam String tag,
                             @RequestParam String text,
                             Model model) {
        messageRepo.save(new Message(tag, text));
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }
}
