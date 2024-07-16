package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Facturation;
import com.snce.facturation.repository.ArticleFactureRepository;
import com.snce.facturation.service.ArticleFactureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleFactureServiceImpl implements ArticleFactureService {
    private ArticleFactureRepository articleFactureRepository;
    @Override
    public Facturation save(Facturation facturation) {
        return articleFactureRepository.save(facturation);
    }

    @Override
    public List<Facturation> getAllArticleFacture() {
        return articleFactureRepository.findAll();
    }

    @Override
    public List<Facturation> getByFacture(Long id) {
        return articleFactureRepository.findByFactureId(id);
    }

    @Override
    public void delete(Long id) {
        articleFactureRepository.deleteById(id);
    }
}
