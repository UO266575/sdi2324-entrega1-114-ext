package com.uniovi.sdimywallapop.services;

import com.uniovi.sdimywallapop.entities.Conversation;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public List<User> getValidUsers() {
        List<User> users = new ArrayList<User>();
        for (User user : usersRepository.findAllActive()) {
            users.add(user);
        }
        return users;
    }


    public User getUser(Long id) {
        return usersRepository.findById(id).get();
    }

    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.updateMoney();
        usersRepository.save(user);
    }

    public void editUser(User user) {
        usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public void decrementMoney(User user, double price) {
        user.decrementMoney(price);
        usersRepository.save(user);
    }

    public void deleteUsers(List<Long> userIds) {
        usersRepository.deleteAllById(userIds);
    }

    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public void addConversation(User user, Conversation newConversation) {
        newConversation.setSeller(user);
        user.addConversation(newConversation);
        usersRepository.save(user);
    }
}

