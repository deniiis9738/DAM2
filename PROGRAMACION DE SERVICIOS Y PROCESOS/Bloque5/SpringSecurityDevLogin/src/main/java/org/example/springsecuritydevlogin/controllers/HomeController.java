package org.example.springsecuritydevlogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping({"/"})
    public String home() {
        return "home";
    }

    @GetMapping({"/leaders"})
    public String leaders() {
        return "leaders";
    }

    @GetMapping({"/systems"})
    public String systems() {
        return "systems";
    }

    @GetMapping({"/access-denied"})
    public String accessDenied() {
        return "access-denied";
    }
}