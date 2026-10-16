package com.devliyez.backend.repository;

import com.devliyez.backend.model.Carga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargaRepository extends JpaRepository<Carga, Long> {
}
