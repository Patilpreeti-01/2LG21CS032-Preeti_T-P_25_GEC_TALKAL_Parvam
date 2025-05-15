package com.example.real.estate.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Registration;
import com.example.real.estate.repository.RegistrationRepository;



@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    // Save or update
    public void saveRegistration(Registration registration) {
        registrationRepository.save(registration);
    }

    // Get all registrations
    public List<Registration> listAll() {
        return registrationRepository.findAll();
    }

    // Get one registration by ID
    public Registration getRegistration(Long id) {
        return registrationRepository.findById(id).orElse(null);
    }

    // Delete by ID
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}