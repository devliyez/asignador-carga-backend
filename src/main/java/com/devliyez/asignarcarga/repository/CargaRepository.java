package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Carga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargaRepository extends JpaRepository<Carga,Long> {
}
