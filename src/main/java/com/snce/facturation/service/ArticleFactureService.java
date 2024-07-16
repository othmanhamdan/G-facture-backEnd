package com.snce.facturation.service;

import com.snce.facturation.entities.Facturation;

import java.util.List;

public interface ArticleFactureService {
    Facturation save(Facturation facturation);

    List<Facturation> getAllArticleFacture();

    List<Facturation> getByFacture(Long id);

    void delete(Long id);
}
