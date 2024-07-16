package com.snce.facturation.DTO;


import com.snce.facturation.entities.Ville;
import lombok.Data;

import java.util.Date;

@Data
public class ClientDTO {
    private Long id;
    private String numClient;
    private String raisonSociale;
    private Date dateCreation;
    private String i_f;
    private String i_c_e;
    private String adresse;
    private String numIdentTva;
    private String groupe;
    private String phyMorale;
    private String cin;
    private String regCommerce;
    private String typeSociete;
    private int nombreDepot;
    private String capaciteTR;
    private Date dateSuppression;
    private int nombreVehicule;
    private String capaciteStockage;
    private Ville ville;

}
