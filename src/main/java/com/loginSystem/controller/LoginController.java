package com.loginSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.loginSystem.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
    
    @Autowired
    LoginService service;
    
    @GetMapping("/login")
    public String viewLoginPage(ModelMap map) {
        return "login";
    }
    
    @PostMapping("/login")
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = service.validateUser(name, password);
        if (!isValidUser) {
            model.put("errorMessage", "Access Denied, Invalid Credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
    
    @GetMapping("/logout")
    public String showLogoutPage(ModelMap model){
        model.clear();
        return "login";
    }
}
