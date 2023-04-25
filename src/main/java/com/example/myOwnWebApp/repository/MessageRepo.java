package com.example.myOwnWebApp.repository;

import com.example.myOwnWebApp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
