package com.snce.facturation.service.imp;

import com.snce.facturation.entities.Ville;
import com.snce.facturation.repository.VilleRepository;
import com.snce.facturation.service.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VilleServiceImpl implements VilleService {
    private VilleRepository villeRepository;
    @Override
    public List<Ville> getVille(String keyword) {
        return villeRepository.selectAllville(keyword);
    }
}
