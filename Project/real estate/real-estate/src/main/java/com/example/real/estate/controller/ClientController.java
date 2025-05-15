package com.example.real.estate.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.real.estate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/clientlogin")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        return clientService.login(username, password)
                .map(client -> "redirect:/propertylist")
                .orElseGet(() -> {
                    model.addAttribute("error", "Invalid credentials");
                    return "loginclient";
                });
    }

    @GetMapping("/clientlogin")
    public String showLoginPage() {
        return "loginclient";
    }
}
    
