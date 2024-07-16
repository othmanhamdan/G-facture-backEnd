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
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelleV;
    @ManyToOne
    private Pays pays;
}
