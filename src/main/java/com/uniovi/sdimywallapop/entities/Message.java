package com.uniovi.sdimywallapop.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    private LocalDateTime date;

    @ManyToOne
    private User user;

    @ManyToOne
    private Conversation conversation;

    public Message() { this.date = LocalDateTime.now(); }

    public Message(String text, User user, Conversation conversation, LocalDateTime date) {
        this.text = text;
        this.user = user;
        this.conversation = conversation;
        this.date = date;
        conversation.addMessage(this);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
