package com.snce.facturation.service;

import com.snce.facturation.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {


    List<Contact> getAllByNomPrenom(String keyword);
}
