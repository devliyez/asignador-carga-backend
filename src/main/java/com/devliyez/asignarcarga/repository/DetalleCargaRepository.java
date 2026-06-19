package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.DetalleCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCargaRepository extends JpaRepository<DetalleCarga, Long> {

    List<DetalleCarga> findByCargaId(Long cargaId);
}
