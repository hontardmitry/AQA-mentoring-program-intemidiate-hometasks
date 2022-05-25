package com.epam.dhontar.aqamp.spring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Value("${main.header}")
    private String header;

    @GetMapping("")
    public String showMainPage(Model model){
        model.addAttribute("test", header);
        return "index";
    }
}
