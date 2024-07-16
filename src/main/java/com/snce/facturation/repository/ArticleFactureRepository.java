package com.snce.facturation.repository;

import com.snce.facturation.entities.Facturation;
import com.snce.facturation.projection.FacturationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleFactureRepository extends JpaRepository<Facturation, Long> {

    List<Facturation> findByFactureId(@Param("id") Long id);
    List<Facturation> findByArticleId(@Param("id") Long id);
    @Query(value = "select a.libarticle AS libarticle, a.unite AS unite , f.tva AS tva , f.quantite AS quantite , f.prix_unitaire AS prixUnitaire from facturation f inner join article a ON f.article_id = a.id WHERE f.facture_id = :id_facture" , nativeQuery = true)
    List<FacturationProjection> exportReport(@Param("id_facture") Long id_facture);
    @Query(value = "select sum((prix_unitaire *quantite)+((prix_unitaire *quantite * tva ) / 100)) from facturation where facture_id = :id" , nativeQuery = true)
    Double totalTCC(@Param("id") Long id);
}
