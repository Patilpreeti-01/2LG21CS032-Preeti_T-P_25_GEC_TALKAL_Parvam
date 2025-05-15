package com.example.real.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.AddProperty;
import com.example.real.estate.repository.AddPropertyRepository;



@Service
public class AddPropertyService {

    @Autowired
    private AddPropertyRepository AddPropertyRepository;

    public List<AddProperty> listAll() {
        return AddPropertyRepository.findAll();
    }

    public void saveAddProperty(AddProperty AddProperty) {
        AddPropertyRepository.save(AddProperty);
    }

    public AddProperty getAddProperty(Long id) {
        return AddPropertyRepository.findById(id).orElse(null);
    }

    public void deleteAddProperty(Long id) {
        AddPropertyRepository.deleteById(id);
    }

    public void save(AddProperty stu) {
       
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    
}
