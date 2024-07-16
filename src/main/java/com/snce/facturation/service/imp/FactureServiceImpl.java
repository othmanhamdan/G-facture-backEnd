package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Facturation;
import com.snce.facturation.entities.Facture;
import com.snce.facturation.repository.ArticleFactureRepository;
import com.snce.facturation.repository.FactureRepository;
import com.snce.facturation.service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FactureServiceImpl implements FactureService {
    private FactureRepository factureRepository;
    private ArticleFactureRepository articleFactureRepository;

    @Override
    public Facture save(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture update(Facture facture) {
        return null;
    }

    @Override
    public Page<Facture> getAllFacture(String searchNum,int page) {
        int size = 10;
        return factureRepository.findAllPage(searchNum.toLowerCase(),PageRequest.of(page,size));
    }

    @Override
    public void delete(Long id) {
        List<Facturation> facturations = articleFactureRepository.findByFactureId(id);
        for (Facturation fac: facturations) {
            articleFactureRepository.delete(fac);
        }
        factureRepository.deleteById(id);
    }

    @Override
    public void valider(Facture facture) {
        Optional<Facture> id = factureRepository.findById(facture.getId());
        if (id.isPresent()){
            facture.setValider(true);
            factureRepository.save(facture);
        }else {
            System.out.println("Identifiant du client invalide");
        }
    }

    @Override
    public Facture byIdFacture(Long id) {
        return factureRepository.findFactureById(id);
    }

    @Override
    public void annuler(Facture facture) {
        Optional<Facture> id = factureRepository.findById(facture.getId());
        if (id.isPresent()){
            facture.setValider(false);
            factureRepository.save(facture);
        }else {
            System.out.println("Identifiant du client invalide");
        }
    }

    @Override
    public Facture modifierFacture(Facture facture) {
        if (facture.getId() != null){
            Optional<Facture> fOptional = factureRepository.findById(facture.getId());
            if (fOptional.isPresent()){
                if (facture.getId() == fOptional.get().getId()){
                    factureRepository.save(facture);
                }

            }
        }
        return facture;
    }
}
