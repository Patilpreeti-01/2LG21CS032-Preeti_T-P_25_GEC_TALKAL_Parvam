package com.example.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.studentcrud.model.Engineer;
import com.example.studentcrud.service.EngineerService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/engineers")
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    @GetMapping("/list")
    public String Engineerlist(Model model) {
        model.addAttribute("engineer",engineerService.listAll() );
        return "engineer/index"; 
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("engineer", new Engineer());
        return "engineer/create";
    }

    @PostMapping("/save")
    public String saveEngineer(@ModelAttribute Engineer eng) {
        engineerService.saveEngineer(eng);
        return "redirect:/engineers/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEngineer(@PathVariable Long id) {
        engineerService.deleteEngineer(id);
        return "redirect:/engineers/list";
    }
    @GetMapping("/edit/{id}")
    public String editEngineer(@PathVariable Long id,Model model) {
        model .addAttribute("engineer",engineerService.getEngineer(id));
        return "engineer/edit";
    }
   
    @PostMapping("/update/{id}")
    public String saveEngineer(@PathVariable Long id, @ModelAttribute Engineer eng) {
           eng.setId(id);
           engineerService.saveEngineer(eng);
           return "redirect:/engineers/list"; 
        }

    }