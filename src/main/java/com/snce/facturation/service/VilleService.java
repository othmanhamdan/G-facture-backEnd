package com.snce.facturation.service;

import com.snce.facturation.entities.Ville;

import java.util.List;

public interface VilleService {
    List<Ville> getVille(String keyword);
}
