package com.snce.facturation.web;

import com.snce.facturation.entities.Ville;
import com.snce.facturation.service.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class VilleController {
    private VilleService villeService;

    @GetMapping("/ville")
    public List<Ville> getAllVille(@RequestParam("keyword") String keyword){
        return villeService.getVille(keyword);
    }
}
