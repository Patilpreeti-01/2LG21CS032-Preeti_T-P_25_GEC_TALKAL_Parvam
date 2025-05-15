package com.example.real.estate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.real.estate.model.Property;
import com.example.real.estate.service.PropertyService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    private final String uploadDir = "src/main/resources/static/images/";

    // Show all properties
    @GetMapping
    public String listProperties(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "property-list"; // Thymeleaf template
    }

    // Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("property", new Property());
        return "addproperty";
    }

    // Save new property
    @PostMapping("/save")
    public String saveProperty(@ModelAttribute Property property,
                               @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                property.setImageUrl("/images/" + fileName);
            }
            propertyService.saveProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/properties";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Property> propertyOpt = propertyService.getPropertyById(id);
        if (propertyOpt.isPresent()) {
            model.addAttribute("property", propertyOpt.get());
            return "editproperty"; // Your edit form template
        }
        return "redirect:/properties";
    }

    // Update property
    @PostMapping("/update/{id}")
    public String updateProperty(@PathVariable Long id,
                                 @ModelAttribute Property updatedProperty,
                                 @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                updatedProperty.setImageUrl("/images/" + fileName);
            } else {
                // Retain old image URL if no new file is uploaded
                propertyService.getPropertyById(id).ifPresent(existing ->
                    updatedProperty.setImageUrl(existing.getImageUrl())
                );
            }
            propertyService.updateProperty(id, updatedProperty);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/properties";
    }

    // Delete property
    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "redirect:/properties";
    }
}
