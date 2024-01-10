package com.uniovi.sdimywallapop.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date creationDate;
    private String details;
    private double price;
    private boolean isSold;
    private Long comprador;
    private String emailComprador;
    private boolean destacado;
    private String image;

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @OneToMany
    private Set<Conversation> conversations;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Offer() {
    }

    public Offer(String title, String description, String details, double price, User user){
        super();
        this.title = title;
        this.description = description;
        this.details = details;
        this.creationDate = new Date();
        this.price = price;
        this.isSold = false;
        this.user = user;
    }

    public Offer(String title, String description, String details, double price, User user, Boolean destacado){
        super();
        this.title = title;
        this.description = description;
        this.details = details;
        this.creationDate = new Date();
        this.price = price;
        this.isSold = false;
        this.user = user;
        this.destacado = destacado;
        this.image = "";
    }
    public Offer(String title, String description, String details, double price, User user, Boolean destacado, String image){
        this(title, description,details,price,user,destacado);
        this.image = image;
    }

    public Offer(Long id, String title, String description, Date creationDate, String details, double price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.details = details;
        this.price = price;
        this.isSold = false;
    }

    public Long getComprador() {
        return comprador;
    }
    
    public void setComprador(Long id) {
        this.comprador = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmailComprador(String email) {
        this.emailComprador = email;
    }
    public String getEmailComprador() {
        return emailComprador;
    }

    public Set<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(Set<Conversation> conversations) {
        this.conversations = conversations;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
