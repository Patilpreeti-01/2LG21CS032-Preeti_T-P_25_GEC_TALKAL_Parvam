package com.example.real.estate.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.real.estate.model.Login;



@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    // Custom finder methods
    
    Login findByEmail(String email);
}
