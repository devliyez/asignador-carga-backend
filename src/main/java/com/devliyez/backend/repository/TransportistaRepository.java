package com.devliyez.backend.repository;

import com.devliyez.backend.model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportistaRepository extends JpaRepository<Transportista,Long> {
    Transportista findFirstByDisponibleTrue();
}
