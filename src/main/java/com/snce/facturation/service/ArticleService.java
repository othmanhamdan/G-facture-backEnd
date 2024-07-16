package com.snce.facturation.service;

import com.snce.facturation.entities.Article;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Article save(Article article);
    Article update(Article article);
    Page<Article> getAllArticle(String keyword, int page);
    void delete(Long id);
    Optional<Article> findById(Long id);

    List<Article> getAllByKeyword(String keyword);
}
