package com.example.real.estate.repository;


import com.example.real.estate.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsernameAndPassword(String username, String password);
}
    

