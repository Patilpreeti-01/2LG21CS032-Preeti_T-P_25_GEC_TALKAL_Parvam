package com.example.real.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.real.estate.model.Register;
import com.example.real.estate.service.RegisterService;



@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    // Show the registration form
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("register", new Register());
        return "create1"; // Refers to register.html (Thymeleaf template)
    }

    // Prepare form with empty Register object
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("register", new Register());
        return "create1"; // Another template (likely lowercase "register.html")
    }

    // Handle form submission
    @PostMapping("/save")
    public String saveRegister(@ModelAttribute Register regi) {
        registerService.saveRegister(regi);
        return "redirect:/signup/list"; // Redirect after saving
    }
    @GetMapping("/signup/list")
    public String getindex1Page(Model model) {
        model.addAttribute("index1",registerService.listAll() );
        return "index1.html";  // This assumes index1.html is in src/main/resources/static
}

    
}
