package com.snce.facturation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numClient;
    private String raisonSociale;
    @Temporal(TemporalType.DATE)
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
    private int nombreVehicule;
    private String capaciteStockage;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    private Contact contact;
    @OneToMany
    private List<Encaissement> encaissements;


}
