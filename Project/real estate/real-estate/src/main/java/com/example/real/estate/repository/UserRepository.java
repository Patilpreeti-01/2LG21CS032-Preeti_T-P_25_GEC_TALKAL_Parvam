package com.example.real.estate.repository;


    


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real.estate.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


