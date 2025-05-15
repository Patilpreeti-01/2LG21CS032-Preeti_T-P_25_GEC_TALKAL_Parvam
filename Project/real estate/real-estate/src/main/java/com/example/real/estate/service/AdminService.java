package com.example.real.estate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Admin;
import com.example.real.estate.repository.AdminRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public String saveAdmin(Admin admin) {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);

        // Set audit fields
        admin.setCreated_on(formattedNow); // Assuming you have a 'created_on' field in your model
        admin.setCreated_by("System User"); // Set the user who is creating the record
        admin.setModified_on(formattedNow); // Assuming you have a 'modified_on' field
        admin.setModified_by("System User"); // Set the modifier
        admin.setDelete_status("Active"); // Assuming you have a 'delete_status' field

        // Save the admin object to the database
        adminRepository.save(admin);

        return "Admin data saved successfully"; // Success message
    }
}
