package com.snce.facturation.repository;


import com.snce.facturation.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select c from Client c where c.raisonSociale like %:keyword% order by c.id DESC ")
    Page<Client> findAllPage(@Param("keyword") String keyword,Pageable pageable);

    List<Client> findAllByRaisonSocialeContains(String keyword);
}
