package com.example.real.estate.controller;

import com.example.real.estate.model.Testimonial;
import com.example.real.estate.service.TestimonialService;
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
@RequestMapping("/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    private final String uploadDir = "src/main/resources/static/uploads/";

    // Show all testimonials
    @GetMapping
    public String listTestimonials(Model model) {
        model.addAttribute("testimonials", testimonialService.getAllTestimonials());
        return "showtest"; // Thymeleaf template to list testimonials
    }

    // Public view
    @GetMapping("/public")
    public String showPublicTestimonials(Model model) {
        model.addAttribute("testimonials", testimonialService.getAllTestimonials());
        return "testimonial"; // Public-facing testimonial page
    }

    // Show add form
    @GetMapping("/addtest")
public String showForm(Model model) {
    model.addAttribute("testimonial", new Testimonial());
    return "addtest";
}

    // Save new testimonial
    @PostMapping("/save")
    public String saveTestimonial(@ModelAttribute Testimonial testimonial,
                                  @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                testimonial.setImageUrl("/uploads/" + fileName);
            }
            testimonialService.saveTestimonial(testimonial);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/testimonials";
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Testimonial> testimonialOpt = testimonialService.getTestimonialById(id);
        if (testimonialOpt.isPresent()) {
            model.addAttribute("testimonial", testimonialOpt.get());
            return "edittest"; // Your edit form template (you need to create this)
        }
        return "redirect:/testimonials";
    }

    // Update testimonial
    @PostMapping("/update/{id}")
    public String updateTestimonial(@PathVariable Long id,
                                    @ModelAttribute Testimonial updatedTestimonial,
                                    @RequestParam("image") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                updatedTestimonial.setImageUrl("/uploads/" + fileName);
            } else {
                testimonialService.getTestimonialById(id).ifPresent(existing ->
                    updatedTestimonial.setImageUrl(existing.getImageUrl())
                );
            }
            testimonialService.updateTestimonial(id, updatedTestimonial);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/testimonials";
    }

    // Delete testimonial
    @GetMapping("/delete/{id}")
    public String deleteTestimonial(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return "redirect:/testimonials";
    }
}
