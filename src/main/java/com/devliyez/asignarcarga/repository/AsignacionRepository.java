package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion,Long> {
}
