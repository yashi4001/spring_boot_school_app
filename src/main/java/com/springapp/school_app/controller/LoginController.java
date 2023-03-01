package com.springapp.school_app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @GetMapping("/login")
    String returnLoginPage(@RequestParam(value = "error",required = false) String error, @RequestParam(value = "logout",required = false) String logout, Model model){
        String msg=null;
        if(error!=null) msg="Invalid credentials";
        if(logout!=null) msg="Successfully logged out";
        model.addAttribute("errorMessge",msg);
        return "login.html";
    }

    @GetMapping("/logout")
    String logoutMethod(HttpServletRequest request, HttpServletResponse response){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();

        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/login?logout=true";
    }
}
