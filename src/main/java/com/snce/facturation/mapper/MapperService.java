package com.snce.facturation.mapper;

import com.snce.facturation.DTO.FactureDTO;
import com.snce.facturation.entities.Facture;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
public class MapperService {
    public FactureDTO fromCommande(Facture commande){
        FactureDTO factureDTO = new FactureDTO();
        BeanUtils.copyProperties(commande,factureDTO);
        return factureDTO;
    }
}
