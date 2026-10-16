package com.devliyez.backend.repository;

import com.devliyez.backend.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {

    Asignacion findByCargaId(Long id);
}
