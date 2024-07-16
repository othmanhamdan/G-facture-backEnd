package com.snce.facturation.repository;


import com.snce.facturation.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "FROM Article c WHERE c.libarticle LIKE %:keyword% order by c.id DESC")
    Page<Article> getArticleAllPage(@Param("keyword") String keyword , Pageable pageable);

    @Query(value = "FROM Article c WHERE c.libarticle LIKE %:keyword% order by c.libarticle")
    List<Article> getAllArticle(@Param("keyword") String keyword);
}
