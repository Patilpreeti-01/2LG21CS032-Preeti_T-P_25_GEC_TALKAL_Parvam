package com.example.real.estate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Mogin;
import com.example.real.estate.repository.MoginRepository;

@Service
public class MoginService {

    @Autowired
    private MoginRepository moginRepository;

    public void saveMogin(Mogin mogin) {
        moginRepository.save(mogin);
    }

    public List<Mogin> listAll() {
        return moginRepository.findAll();
    }

    public Mogin getLastSaved() {
        List<Mogin> all = moginRepository.findAll();
        if (!all.isEmpty()) {
            return all.get(all.size() - 1); // Simple way to get last entry
        }
        return null;
    }
}