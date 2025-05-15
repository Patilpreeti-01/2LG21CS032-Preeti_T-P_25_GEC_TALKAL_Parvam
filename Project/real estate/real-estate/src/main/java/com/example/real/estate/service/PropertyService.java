package com.example.real.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Property;
import com.example.real.estate.repository.PropertyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // Save or update property
    public void saveProperty(Property property) {
        propertyRepository.save(property);
    }

    // Get all properties
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    // Get property by ID
    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    // Delete property by ID
    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }

    // Update property
    public void updateProperty(Long id, Property updatedProperty) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (optionalProperty.isPresent()) {
            Property existing = optionalProperty.get();
            existing.setTitle(updatedProperty.getTitle());
            existing.setDescription(updatedProperty.getDescription());
            existing.setSize(updatedProperty.getSize());
            existing.setPrice(updatedProperty.getPrice());
            existing.setAddress(updatedProperty.getAddress());
            existing.setImageUrl(updatedProperty.getImageUrl()); // Optional: only if image changed

            propertyRepository.save(existing);
        }
    }
}
