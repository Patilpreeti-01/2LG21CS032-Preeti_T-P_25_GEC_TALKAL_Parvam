package com.example.studentcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcrud.model.Engineer;
import com.example.studentcrud.repository.EngineerRepository;

@Service
public class EngineerService {

    @Autowired
    private  EngineerRepository engineerRepository;

    public List<Engineer> listAll() {
        return engineerRepository.findAll();
    }

    public void saveEngineer(Engineer engineer) {
        engineerRepository.save(engineer);
    }

    public Engineer getEngineer(Long id) {
        return engineerRepository.findById(id).orElse(null);
    }

    public void deleteEngineer(Long id) {
        engineerRepository.deleteById(id);
    }
}