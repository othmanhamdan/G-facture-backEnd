package com.snce.facturation.repository;

import com.snce.facturation.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    List<Contact> findAllByNomPrenomContains(String keyword);
}
