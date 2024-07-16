package com.snce.facturation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facturation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prixUnitaire;
    private double quantite;
    private int tva;
    @ManyToOne
    private Facture facture;
    @ManyToOne
    private Article article;
}
