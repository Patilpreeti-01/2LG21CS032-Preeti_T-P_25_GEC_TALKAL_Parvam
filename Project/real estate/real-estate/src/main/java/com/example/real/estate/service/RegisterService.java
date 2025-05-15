package com.example.real.estate.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Register;
import com.example.real.estate.repository.RegisterRepository;



@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public List<Register> listAll() {
        return registerRepository.findAll();
    }

    public void saveRegister(Register register) {
        registerRepository.save(register);
    }
}
