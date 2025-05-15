package com.example.real.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.real.estate.model.Testimonial;
import com.example.real.estate.repository.TestimonialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    // Save or update testimonial
    public void saveTestimonial(Testimonial testimonial) {
        testimonialRepository.save(testimonial);
    }

    // Get all testimonials
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    // Get testimonial by ID
    public Optional<Testimonial> getTestimonialById(Long id) {
        return testimonialRepository.findById(id);
    }

    // Delete testimonial by ID
    public void deleteTestimonial(Long id) {
        testimonialRepository.deleteById(id);
    }

    // Update testimonial
    public void updateTestimonial(Long id, Testimonial updatedTestimonial) {
        Optional<Testimonial> optional = testimonialRepository.findById(id);
        if (optional.isPresent()) {
            Testimonial existing = optional.get();
            existing.setTitle(updatedTestimonial.getTitle());
            existing.setDescription(updatedTestimonial.getDescription());
            existing.setImageUrl(updatedTestimonial.getImageUrl()); // Only if image changed

            testimonialRepository.save(existing);
        }
    }
}
