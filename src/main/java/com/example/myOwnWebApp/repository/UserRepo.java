package com.example.myOwnWebApp.repository;

import com.example.myOwnWebApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
