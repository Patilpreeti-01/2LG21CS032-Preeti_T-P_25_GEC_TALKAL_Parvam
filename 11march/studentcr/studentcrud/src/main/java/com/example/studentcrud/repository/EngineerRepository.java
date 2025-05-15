package com.example.studentcrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentcrud.model.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Long>  {
}