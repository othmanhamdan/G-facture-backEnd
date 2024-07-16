package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Article;
import com.snce.facturation.entities.Facturation;
import com.snce.facturation.entities.Facture;
import com.snce.facturation.repository.ArticleFactureRepository;
import com.snce.facturation.repository.ArticleRepository;
import com.snce.facturation.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    private ArticleFactureRepository articleFactureRepository;
    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article update(Article article) {
        if (article.getId() != null){
            Optional<Article> aOptional = articleRepository.findById(article.getId());
            if (aOptional.isPresent()){
                if (article.getId() == aOptional.get().getId()){
                    articleRepository.save(article);
                }

            }
        }
        return article;
    }

    @Override
    public Page<Article> getAllArticle(String keyword, int page) {
        int size = 10;
        return articleRepository.getArticleAllPage(keyword.toLowerCase(), PageRequest.of(page,size));
    }

    @Override
    public void delete(Long id) {
        List<Facturation> facturations = articleFactureRepository.findByArticleId(id);
        for (Facturation fac: facturations) {
            articleFactureRepository.delete(fac);
        }
        articleRepository.deleteById(id);
    }

    @Override
    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> getAllByKeyword(String keyword) {
        return articleRepository.getAllArticle(keyword);
    }
}
