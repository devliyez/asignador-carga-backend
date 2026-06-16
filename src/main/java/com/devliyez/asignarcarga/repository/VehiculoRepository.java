package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {
}
