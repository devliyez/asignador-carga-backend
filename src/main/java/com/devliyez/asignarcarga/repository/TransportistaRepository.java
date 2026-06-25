package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportistaRepository extends JpaRepository<Transportista,Long> {
    Transportista findFirstByDisponibleTrue();
}
