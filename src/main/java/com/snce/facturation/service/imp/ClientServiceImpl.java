package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Article;
import com.snce.facturation.entities.Client;
import com.snce.facturation.entities.Facture;
import com.snce.facturation.repository.ClientRepository;
import com.snce.facturation.repository.FactureRepository;
import com.snce.facturation.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private FactureRepository factureRepository;
    @Override
    public Page<Client> getAllClientPage(String keyword,int page) {
        int size = 10;
        return clientRepository.findAllPage(keyword,PageRequest.of(page,size));
    }
    @Override
    public List<Client> getAllClient(String keyword) {
        return clientRepository.findAllByRaisonSocialeContains(keyword);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client update(Client client) {
        if (client.getId() != null){
            Optional<Client> cOptional = clientRepository.findById(client.getId());
            if (cOptional.isPresent()){
                if (client.getId() == cOptional.get().getId()){
                    clientRepository.save(client);
                }

            }
        }
        return client;
    }

    @Override
    public void delete(Long id) {
        List<Facture> factures = factureRepository.findByClientId(id);
        for (Facture facture: factures) {
            factureRepository.delete(facture);

        }
        clientRepository.deleteById(id);
    }
}
