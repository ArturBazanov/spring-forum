package com.github.cloudbonus.forum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "message")
@NoArgsConstructor
@Setter
@Getter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="message")
    @NotEmpty(message = "")
    @Size(min = 5, max = 100, message = "The message must be between 5 and 100 characters long.")
    private String text;

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }
}
