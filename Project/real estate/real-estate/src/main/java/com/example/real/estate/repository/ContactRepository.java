
package com.example.real.estate.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.real.estate.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Add custom query methods here if needed
}
