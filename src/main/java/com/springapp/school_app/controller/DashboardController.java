package com.springapp.school_app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    String returnDashboard(Model model, Authentication authentication){
        model.addAttribute("username",authentication.getName());
        model.addAttribute("roles",authentication.getAuthorities().toString());
        //throw new RuntimeException("Testing exception");
        return "dashboard.html";
    }
}
