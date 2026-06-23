package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {

    Asignacion findByCargaId(Long id);
}
