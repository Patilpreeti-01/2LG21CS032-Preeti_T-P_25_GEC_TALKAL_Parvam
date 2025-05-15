package com.example.real.estate.controller;

import com.example.real.estate.model.Agent;
import com.example.real.estate.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    private final String uploadDir = "src/main/resources/static/images/";

    // Show all agents
    @GetMapping
    public String listAgents(Model model) {
        model.addAttribute("agents", agentService.getAllAgents());
        return "agent"; // agent.html (card layout)
    }

    // Show register form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("agent", new Agent());
        return "register"; // register.html
    }

    // Save new agent
    @PostMapping("/save")
    public String saveAgent(@ModelAttribute Agent agent,
                            @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                agent.setImageUrl("/images/" + fileName);
            }
            agentService.saveAgent(agent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/agents";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Agent> agentOpt = agentService.getAgentById(id);
        if (agentOpt.isPresent()) {
            model.addAttribute("agent", agentOpt.get());
            return "register"; // Reuse the register form
        }
        return "redirect:/agents";
    }

    // Update agent
    @PostMapping("/update/{id}")
    public String updateAgent(@PathVariable Long id,
                              @ModelAttribute Agent updatedAgent,
                              @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                updatedAgent.setImageUrl("/images/" + fileName);
            } else {
                // Retain old image
                agentService.getAgentById(id).ifPresent(existing ->
                    updatedAgent.setImageUrl(existing.getImageUrl())
                );
            }
            agentService.updateAgent(id, updatedAgent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/agents";
    }

    // Delete agent
    @GetMapping("/delete/{id}")
    public String deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return "redirect:/agents";
    }
}
