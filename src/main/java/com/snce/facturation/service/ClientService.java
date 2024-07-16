package com.snce.facturation.service;

import com.snce.facturation.entities.Client;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Page<Client> getAllClientPage(String keyword,int page);
    List<Client> getAllClient(String keyword);
    Client save(Client client);

    Optional<Client> getById(Long id);

    Client update(Client client);

    void delete(Long id);
}
