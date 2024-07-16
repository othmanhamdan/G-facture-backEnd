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
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numFacture;
    private String usineLivraison;
    private String numCamion;
    private String typeFacture;
    private String exonereTva;
    private String ObjetFacture;
    private String ObjetMarche;
    private String ObjetMois;
    private boolean valider;
    private String modLivraison;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @ManyToOne
    private Client client;
    @OneToMany
    private List<Facturation> facturations;

}
