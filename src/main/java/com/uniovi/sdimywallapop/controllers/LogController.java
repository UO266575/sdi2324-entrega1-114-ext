package com.uniovi.sdimywallapop.controllers;

import com.uniovi.sdimywallapop.services.LogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LogController {

    @Autowired
    private LogServices logServices;

    @RequestMapping("/log/list")
    public String getListado(Model model) {
        model.addAttribute("logList", logServices.getLogs());
        return "log/list";
    }

    @RequestMapping("/log/list/update")
    public String updateList(Model model){
        model.addAttribute("logList", logServices.getLogs());
        return "log/list :: tableLogs";
    }

    @RequestMapping("/unauthorized")
    public String unauthorizedList(){
        return "unauthorized";
    }

    //Tipos definidos en el enunciado
    @RequestMapping("/log/list/tipe/{tipo}")
    public String petList(Model model, @PathVariable String tipo){
        model.addAttribute("logList", logServices.getPetLogs(tipo));
        return "log/list :: tableLogs";
    }

    @PostMapping("/log/delete")
    public String delete() {
        logServices.deleteLogs();
        return "redirect:/log/list";
    }

}
