package com.github.cloudbonus.forum.repository;

import com.github.cloudbonus.forum.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByOrderByIdDesc();
}
