package com.example.real.estate.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.real.estate.model.Login;
import com.example.real.estate.service.LoginService;


@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Show the registration form
    @GetMapping("/sign")
    public String showSignUpForm(Model model) {
        model.addAttribute("login", new Login());
        return "create3"; // Refers to register.html (Thymeleaf template)
    }

    // Prepare form with empty Register object
    @GetMapping("/creat")
    public String showCreateForm(Model model) {
        model.addAttribute("login", new Login());
        return "create3"; // Another template (likely lowercase "register.html")
    }

    // Handle form submission
    @PostMapping("/save_login")
    public String saveLogin(@ModelAttribute Login regi) {
        loginService.saveLogin(regi);
        return "redirect:/sign/list"; // Redirect after saving
    }
    @GetMapping("/sign/list")
    public String getindex3Page(Model model) {
        model.addAttribute("index1",loginService.listAll() );
        return "index3.html";  // This assumes index1.html is in src/main/resources/static
}
    
}
