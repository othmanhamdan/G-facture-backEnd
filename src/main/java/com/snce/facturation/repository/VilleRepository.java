package com.snce.facturation.repository;

import com.snce.facturation.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {
    @Query(value = "FROM Ville c WHERE c.libelleV LIKE %:keyword%")
    List<Ville> selectAllville(@Param("keyword") String keyword);
}
