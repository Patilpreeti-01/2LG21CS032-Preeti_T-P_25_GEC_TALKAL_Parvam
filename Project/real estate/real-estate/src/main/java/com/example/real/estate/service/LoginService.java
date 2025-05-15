package com.example.real.estate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Login;
import com.example.real.estate.repository.LoginRepository;



@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> listAll() {
        return loginRepository.findAll();
    }

    public void saveLogin(Login login) {
        loginRepository.save(login);
    }
}
