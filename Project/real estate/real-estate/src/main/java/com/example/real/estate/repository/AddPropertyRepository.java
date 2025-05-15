package com.example.real.estate.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.real.estate.model.AddProperty;

@Repository
public interface AddPropertyRepository extends JpaRepository<AddProperty, Long> {
    
}
 



    

