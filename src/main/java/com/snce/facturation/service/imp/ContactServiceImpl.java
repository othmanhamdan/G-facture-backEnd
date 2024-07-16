package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Contact;
import com.snce.facturation.repository.ContactRepository;
import com.snce.facturation.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    @Override
    public List<Contact> getAllByNomPrenom(String keyword) {
        return contactRepository.findAllByNomPrenomContains(keyword);
    }
}
