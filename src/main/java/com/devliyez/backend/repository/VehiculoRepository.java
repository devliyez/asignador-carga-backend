package com.devliyez.backend.repository;

import com.devliyez.backend.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository <Vehiculo,Long> {

    Vehiculo findFirstByDisponibleTrue();
}
