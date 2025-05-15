package com.example.real.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real.estate.model.Registration;


public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    Registration findByEmail(String email);
}
