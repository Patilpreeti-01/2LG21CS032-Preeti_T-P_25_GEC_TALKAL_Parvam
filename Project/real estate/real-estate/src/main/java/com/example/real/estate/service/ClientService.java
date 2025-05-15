package com.example.real.estate.service;

import com.example.real.estate.model.Client;
import com.example.real.estate.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> login(String username, String password) {
        return clientRepository.findByUsernameAndPassword(username, password);
    }
}