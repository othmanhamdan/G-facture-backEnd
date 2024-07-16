package com.snce.facturation.web;

import com.snce.facturation.entities.Facture;
import com.snce.facturation.service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/facture")
@CrossOrigin("*")
public class FactureController {
    private FactureService factureService;

    @PostMapping("")
    public Facture saveFacture(@RequestBody Facture facture){
        System.out.println(facture.getModLivraison());
        return factureService.save(facture);
    }
    @GetMapping("")
    public Page<Facture> getAll(@RequestParam() int page,
                                @RequestParam() String searchNum){
        return factureService.getAllFacture(searchNum,page);
    }
    @GetMapping("byId")
    public Facture byId(@RequestParam() Long id){
        return factureService.byIdFacture(id);
    }
    @PutMapping("/valide")
    public void valide(@RequestBody Facture facture){
        factureService.valider(facture);
    }
    @PutMapping("/annuler")
    public void annuler(@RequestBody Facture facture){
        factureService.annuler(facture);
    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        factureService.delete(id);
    }

    @PutMapping("/update")
    public Facture update(@RequestBody Facture facture){
        return factureService.modifierFacture(facture);
    }


}
