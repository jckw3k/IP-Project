package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "dashboard";
    }

    @PostMapping("/authenticate")
    public ModelAndView authenticate(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        if ("admin".equals(username) && "password123".equals(password)) {
            return new ModelAndView("index", "message", "Welcome, " + username + "!");
        } else {
            return new ModelAndView("login", "error", "Invalid Username or Password");
        }
    }
