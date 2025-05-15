package com.example.real.estate.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.real.estate.model.Mogin;

import com.example.real.estate.service.MoginService;






@Controller
public class MoginController {

    @Autowired
    private MoginService moginService;

    // Show the registration form
    @GetMapping("/sign_next")
    public String showSignUpForm(Model model) {
        model.addAttribute("mogin", new Mogin());
        return "create4"; // Refers to register.html (Thymeleaf template)
    }

    // Prepare form with empty Register object
    @GetMapping("/create-mogin")  // Renamed to avoid conflict
public String showCreateForm() {
    return "redirect:/addproperty";
}

    // Handle form submission
   @PostMapping("/save_agent")
public String saveMogin(@ModelAttribute Mogin regi, RedirectAttributes redirectAttributes) {
    moginService.saveMogin(regi);
    redirectAttributes.addFlashAttribute("mogin", regi); // Temporarily store for redirect
    return "redirect:/addproperty"; // Better URL naming
}

@GetMapping("/addproperty")
public String showAddPropertyPage(@ModelAttribute("mogin") Mogin mogin, Model model) {
    model.addAttribute("mogin", mogin); // Make sure it's available in Thymeleaf
    return "addproperty"; // Thymeleaf template name
}
}
