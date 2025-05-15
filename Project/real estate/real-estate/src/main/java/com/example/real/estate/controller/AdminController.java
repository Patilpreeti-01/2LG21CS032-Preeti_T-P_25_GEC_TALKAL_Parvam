package com.example.real.estate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.real.estate.model.Admin;
import com.example.real.estate.repository.AdminRepository;
import com.example.real.estate.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Display the login form and pass an empty Admin object to Thymeleaf
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("admin", new Admin()); // Pass an empty Admin object
        return "login"; // Returns templates/login.html
    }

    // Handle form submission
    @PostMapping("/login") // This matches the form action in the HTML
    public String submitAdmin(@ModelAttribute Admin admin) {
        // Call the service to save admin data to the database
        adminService.saveAdmin(admin); // Save the Admin entity to the database

        // Redirect to the admin dashboard after successful form submission
        return "redirect:/dashboard"; // Redirect to dashboard
    }

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/admin/login")
    public String login(@RequestParam String username,
            @RequestParam String emailid,
            @RequestParam String password) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setEmailid(emailid);
        admin.setPassword(password);

        adminRepository.save(admin); // This should now work

        return "success"; // your confirmation view
    }

}