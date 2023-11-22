package com.github.cloudbonus.forum.service;

import com.github.cloudbonus.forum.model.Message;
import com.github.cloudbonus.forum.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Transactional
    public void leaveComment(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getComments() {
        return messageRepository.findAllByOrderByIdDesc();
    }
}
