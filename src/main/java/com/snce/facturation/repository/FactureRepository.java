package com.snce.facturation.repository;

import com.snce.facturation.entities.Facture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query(value = "select f.num_facture AS numFacture, f.date_facture AS dateFacture, f.objet_facture AS ObjetFacture, f.objet_marche AS ObjetMarche, f.objet_mois AS ObjetMois, c.adresse AS adresse, c.raison_sociale AS raisonSociale, c.i_c_e AS i_c_e, v.libelle_v AS libelle_v from facture f inner join client c ON f.client_id = c.id inner join ville v ON c.ville_id = v.id WHERE f.id = :id" , nativeQuery = true)
    Facture factureByReport(@Param("id") Long id);

    //Page<Facture> findAllFacture(int page, int size);
    Facture findFactureById(Long id);

    @Query(value = "select c from Facture c where c.numFacture like %:numFacture% order by c.id DESC ")
    Page<Facture> findAllPage(@Param("numFacture") String numFacture,Pageable pageable);

    List<Facture> findByClientId(@Param("id") Long id);
}
