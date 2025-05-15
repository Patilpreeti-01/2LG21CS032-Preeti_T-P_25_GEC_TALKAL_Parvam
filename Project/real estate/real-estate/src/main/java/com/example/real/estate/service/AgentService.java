package com.example.real.estate.service;

import com.example.real.estate.model.Agent;
import com.example.real.estate.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    // Save or update agent
    public void saveAgent(Agent agent) {
        agentRepository.save(agent);
    }

    // Get all agents
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    // Get agent by ID
    public Optional<Agent> getAgentById(Long id) {
        return agentRepository.findById(id);
    }

    // Delete agent by ID
    public void deleteAgent(Long id) {
        agentRepository.deleteById(id);
    }

    // Update agent
    public void updateAgent(Long id, Agent updatedAgent) {
        Optional<Agent> optionalAgent = agentRepository.findById(id);
        if (optionalAgent.isPresent()) {
            Agent existing = optionalAgent.get();
            existing.setUsername(updatedAgent.getUsername());
            existing.setEmail(updatedAgent.getEmail());
            existing.setPassword(updatedAgent.getPassword());
            existing.setCreatedBy(updatedAgent.getCreatedBy());
            existing.setCreatedBy(updatedAgent.getCreatedBy());
            existing.setModifiedBy(updatedAgent.getModifiedBy());
            existing.setModifiedBy(updatedAgent.getModifiedBy());
            existing.setDeleteStatus(updatedAgent.getDeleteStatus());

            agentRepository.save(existing);
        }
    }
}
