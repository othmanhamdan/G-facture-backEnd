package com.snce.facturation.web;

import com.snce.facturation.entities.Contact;
import com.snce.facturation.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ContactController {
    private ContactService contactService;

    @GetMapping("/contact")
    public List<Contact> getAll(@RequestParam("keyword") String keyword){
        return contactService.getAllByNomPrenom(keyword);
    }

}
