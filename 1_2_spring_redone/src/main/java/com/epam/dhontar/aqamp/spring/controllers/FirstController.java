package com.epam.dhontar.aqamp.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodBye(@RequestParam(value = "name", required = false)      String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {
        model.addAttribute("message", "Goodbye, " + name + " " + surname);
        return "first/goodbye";
    }
}
