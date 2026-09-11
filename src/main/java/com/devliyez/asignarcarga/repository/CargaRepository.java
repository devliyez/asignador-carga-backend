package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.dto.CargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.model.DetalleCarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargaRepository extends JpaRepository<Carga,Long> {
    List<Carga> findByClienteUsuarioId(Long ClienteId);

}
