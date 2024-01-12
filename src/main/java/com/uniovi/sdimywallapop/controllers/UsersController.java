package com.uniovi.sdimywallapop.controllers;

import com.uniovi.sdimywallapop.entities.Log;
import com.uniovi.sdimywallapop.entities.User;
import com.uniovi.sdimywallapop.services.*;
import com.uniovi.sdimywallapop.validators.SignUpFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private RolesService rolesService;
    @Autowired
    private SignUpFormValidator signUpFormValidator;
    @Autowired
    private UsersService usersService;
    @Autowired
    private LogServices logServices;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private ConversationService conversationService;

    @RequestMapping("/user/list")
    public String getListado(Model model, Principal principal) {
        String email = principal.getName(); // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("usersList", usersService.getValidUsers());
        return "user/list";
    }

    @RequestMapping(value = "/user/add")
    public String getUser(Model model, Principal principal) {
        String email = principal.getName(); // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("rolesList", rolesService.getRoles());
        return "user/add";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String setUser(@ModelAttribute User user) {
        usersService.addUser(user);
        return "redirect:/user/list";
    }

    @PostMapping("/user/delete")
    public String delete(@RequestParam(value = "ck", required = false) List<Long> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            // No se han seleccionado usuarios para eliminar
            return "redirect:/user/list";
        }
        //Primero eliminamos las conversaciones de las que forme parte el usuario
        userIds.stream()
                .forEach(id -> {
                    List<Long> convs = conversationService.searchConversationsTakingPartBy(usersService.getUser(id));
                    convs.stream().forEach(convId -> conversationService.deleteConversation(convId));
                });
        // Elimina los usuarios seleccionados
        usersService.deleteUsers(userIds);

        return "redirect:/user/list";
    }

    @RequestMapping(value = "/user/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        User user = usersService.getUser(id);
        model.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@PathVariable Long id, @ModelAttribute User user) {
        User originalUser = usersService.getUser(user.getId());
        originalUser.setEmail(user.getEmail());
        originalUser.setName(user.getName());
        originalUser.setLastName(user.getLastName());
        //originalUser.setPassword(user.getPassword());
        usersService.editUser(originalUser);
        return "redirect:/user/details/" + id;
    }

    @RequestMapping("/user/list/update")
    public String updateList(Model model, Principal principal) {
        model.addAttribute("usersList", usersService.getValidUsers());
        String email = principal.getName(); // email es el name de la autenticación
        User user = usersService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "user/list :: tableUsers";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@Validated User user, BindingResult result) {
        signUpFormValidator.validate(user, result);
        if (result.hasErrors()) {
            return "signup";
        } else {
            logServices.addLog(new Log("ALTA", new Date(), "Mapeo: signup /signup"));
        }
        user.setRole(rolesService.getRoles()[0]);
        usersService.addUser(user);
        securityService.autoLogin(user.getEmail(), user.getPasswordConfirm());
        logServices.addLog(new Log("LOGIN-EX", new Date(), user.getEmail()));
        return "redirect:home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")) {
            return "redirect:home";
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String email = auth.getName();
        User activeUser = usersService.getUserByEmail(email);
        if (activeUser.getRole().equals("ROLE_ADMIN")) {
            return "redirect:user/list";
        } else {
            return "redirect:offer/myList";
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.getName().equals("anonymousUser")) {
            return "redirect:home";
        }
        model.addAttribute("user", new User());
        return "signup";
    }
}