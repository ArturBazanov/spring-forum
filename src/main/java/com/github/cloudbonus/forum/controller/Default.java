package com.github.cloudbonus.forum.controller;

import com.github.cloudbonus.forum.model.Message;
import com.github.cloudbonus.forum.model.User;
import com.github.cloudbonus.forum.repository.MessageRepository;
import com.github.cloudbonus.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Default {
    private MessageRepository messageRepository;

    @Autowired
    public Default(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/")
    public String addMessage(@RequestParam String text,
                             Model model) {
        messageRepository.save(new Message(text));
        Iterable<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }
}
