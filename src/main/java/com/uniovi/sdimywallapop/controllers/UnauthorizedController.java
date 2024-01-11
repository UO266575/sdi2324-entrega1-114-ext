package com.uniovi.sdimywallapop.controllers;

import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UnauthorizedController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model, Principal principal){
        String email = principal.getName(); // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "unauthorized";
    }
}
