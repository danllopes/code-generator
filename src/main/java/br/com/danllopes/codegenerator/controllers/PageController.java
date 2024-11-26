package br.com.danllopes.codegenerator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/", "/qr", "/home"})
    public String getHomePage() {
        return "index";
    }
}
