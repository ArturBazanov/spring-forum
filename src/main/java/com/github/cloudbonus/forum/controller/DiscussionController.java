package com.github.cloudbonus.forum.controller;

import com.github.cloudbonus.forum.model.Message;
import com.github.cloudbonus.forum.security.HttpUserDetails;
import com.github.cloudbonus.forum.service.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/discussion")
public class DiscussionController {
    private final MessageService messageService;

    @Autowired
    public DiscussionController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ModelAttribute("messages")
    public List<Message> getMessages() {
        return messageService.getComments();
    }
    @GetMapping
    public String boardPage(@ModelAttribute("message") Message message) {
        return "discussion/board";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("message") @Valid Message message, BindingResult bindingResult,
                             @AuthenticationPrincipal HttpUserDetails userDetails) {
        if (bindingResult.hasErrors()) return "discussion/board";
        message.setUser(userDetails.getUser());
        messageService.leaveComment(message);
        return "redirect:/discussion";
    }
}
