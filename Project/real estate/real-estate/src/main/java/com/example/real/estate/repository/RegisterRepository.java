package com.example.real.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.real.estate.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Long> {
}