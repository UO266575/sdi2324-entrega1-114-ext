package com.uniovi.sdimywallapop.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy="conversation", cascade = CascadeType.ALL)
    private List<Message> messages;

    @ManyToOne
    @JoinColumn(name = "seller")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private User buyer;

    @ManyToOne
    @JoinColumn(name = "offer")
    private Offer offer;

    public Conversation () {
    }

    public Conversation(User seller, User buyer, Offer offer, Message message) {
        this(seller, buyer, offer, new ArrayList<Message>());
        this.messages.add(message);
    }

    public Conversation(User seller, User buyer, Offer offer) {
        this(seller, buyer, offer, new ArrayList<Message>());
    }

    public Conversation(User seller, User buyer, Offer offer, List<Message> messages) {
        super();
        this.buyer = buyer;
        this.seller = seller;
        this.offer = offer;
        this.messages = messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
