package com.example.real.estate.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real.estate.model.Cogin;


public interface CoginRepository extends JpaRepository<Cogin, Long> {
    // Optional: custom query methods here
}