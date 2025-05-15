package com.example.real.estate.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Cogin;

import com.example.real.estate.repository.CoginRepository;




@Service
public class CoginService {

    @Autowired
    private CoginRepository coginRepository;

    public List<Cogin> listAll() {
        return coginRepository.findAll();
    }

    public void saveLogin(Cogin cogin) {
        coginRepository.save(cogin);
    }

    public void saveCogin(Cogin regi) {
      
        throw new UnsupportedOperationException("Unimplemented method 'saveCogin'");
    }

    
    
}

