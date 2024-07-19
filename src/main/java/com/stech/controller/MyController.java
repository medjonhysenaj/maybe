package com.stech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("message", "Hello, Vidzeme University!");
        return "greeting"; // Make sure this matches the name of your 
    }                      // Thymeleaf template without the .html extension
} 