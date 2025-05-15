package com.example.real.estate.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.real.estate.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    // You can define custom queries here if needed, for example:
    // Optional<Admin> findByUsername(String username);
}
