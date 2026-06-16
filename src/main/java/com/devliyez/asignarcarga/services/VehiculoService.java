package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {


    List<Vehiculo> getVehiculos (); //GET
    Optional<Vehiculo> getVehiculoById(Long id); //GET por ID
    Vehiculo updateVehiculo(Vehiculo vehiculo, Long id); // EDITAR
    Vehiculo postVehiculo(Vehiculo vehiculo); // POST
    void deleteVehiculo(Long id);


}
