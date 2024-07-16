package com.snce.facturation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codeArticle;
    private String libarticle;
    private String unite;
    private String usineFabrication;
    private String articleVentable;
    private String fabrique;
    private String familleProduit;
    private String classeProduit;
    @Temporal(TemporalType.DATE)
    private Date dateArticle;
    private double prixUnitaire;
    private int tva;


}
