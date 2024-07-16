package com.snce.facturation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Encaissement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numEncssm;
    private Date dateEncssm;
    private Date dateEcheance;
    private Date natureEncssm;
    private double montant;
    private String observation;
    @ManyToOne
    private Client client;
}
