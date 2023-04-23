package com.example.myOwnWebApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "consumer")
@NoArgsConstructor
@Setter
@Getter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String email;
    private String password;
    private boolean active;
    @ElementCollection(targetClass = ROLE.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns= @JoinColumn(name = "user_id"))
    private Set<ROLE> roleSet;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
