package com.snce.facturation.service;

import com.snce.facturation.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FactureService {
    Facture save(Facture facture);
    Facture update(Facture facture);
    Page<Facture> getAllFacture(String searchNum,int page );
    void delete(Long id);

    void valider(Facture facture);

    Facture byIdFacture(Long id);

    void annuler(Facture facture);

    Facture modifierFacture(Facture facture);
}
