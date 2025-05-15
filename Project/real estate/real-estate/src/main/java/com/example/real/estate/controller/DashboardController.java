package com.example.real.estate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // returns dashboard.html
    }

    @GetMapping("/showproperty")
    public String showProperty() {
        return "showproperty"; // you should also have showproperty.html
    }

   

    @GetMapping("/showtestimonials")
    public String showTestimonials() {
        return "showtest"; // you should have showtest.html
    }

    
}
