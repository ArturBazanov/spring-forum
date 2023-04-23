package com.example.myOwnWebApp.controllers;

import com.example.myOwnWebApp.models.Message;
import com.example.myOwnWebApp.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Default {
    private MessageRepo messageRepo;

    @Autowired
    public Default(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/hello")
    public String helloPage() {
        return "hello";
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
