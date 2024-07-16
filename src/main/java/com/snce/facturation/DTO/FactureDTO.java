package com.snce.facturation.DTO;

import com.snce.facturation.entities.Client;
import com.snce.facturation.entities.Facturation;
import com.snce.facturation.entities.ModeLivraison;
import lombok.Data;

import java.util.Date;


@Data
public class FactureDTO {
    private Long id;
    private String numFacture;
    private String ObjetFacture;
    private String ObjetMarche;
    private String ObjetMois;
    private Date dateFacture;
    private Client client;
    //private ModeLivraison modeLivraison;
}
