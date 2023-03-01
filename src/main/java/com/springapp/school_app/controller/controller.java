package com.springapp.school_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller{
    @RequestMapping(value={"/home","/",""})
    public String getHome(){
        return "home.html";
    }
}
