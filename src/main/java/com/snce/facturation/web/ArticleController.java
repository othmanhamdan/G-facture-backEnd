package com.snce.facturation.web;

import com.snce.facturation.entities.Article;
import com.snce.facturation.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/article")
public class ArticleController {
    private ArticleService articleService;

    @PostMapping("")
    public Article saveArticle(@RequestBody Article article){
        return articleService.save(article);
    }
    @GetMapping("/page")
    public Page<Article> getAllPage(@RequestParam() int page,
                                @RequestParam() String keyword){
        return articleService.getAllArticle(keyword,page);
    }
    @GetMapping("/byId")
    public Optional<Article> findById(@RequestParam() Long id){
        return articleService.findById(id);
    }
    @GetMapping("")
    public List<Article> getAll(@RequestParam() String keyword){
        return articleService.getAllByKeyword(keyword);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        articleService.delete(id);
    }
    @PutMapping("")
    public Article update(@RequestBody Article article){
        return articleService.update(article);
    }

}
