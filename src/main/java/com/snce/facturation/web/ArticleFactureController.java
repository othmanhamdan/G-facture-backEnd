package com.snce.facturation.web;

import com.snce.facturation.entities.Facturation;
import com.snce.facturation.service.ArticleFactureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/articleFacture")
public class ArticleFactureController {
    private ArticleFactureService articleFactureService;

    @PostMapping("")
    public Facturation save(@RequestBody Facturation facturation){
        return articleFactureService.save(facturation);
    }
    @GetMapping("")
    public List<Facturation> getAll(){
        return articleFactureService.getAllArticleFacture();
    }

    @GetMapping("/getByFacture")
    public List<Facturation> getByFacture(@RequestParam Long id){
        return articleFactureService.getByFacture(id);
    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        articleFactureService.delete(id);
    }
}
