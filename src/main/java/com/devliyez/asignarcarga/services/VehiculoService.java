package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.dto.vehiculoRequest;
import com.devliyez.asignarcarga.dto.vehiculoResponse;
import com.devliyez.asignarcarga.model.Vehiculo;

import java.util.List;
import java.util.Optional;

public interface VehiculoService {


    List<vehiculoResponse> getVehiculos (); //GET
    vehiculoResponse getVehiculoById(Long id); //GET por ID
    vehiculoResponse updateVehiculo(vehiculoRequest vehiculo, Long id); // EDITAR
    vehiculoResponse postVehiculo(vehiculoRequest vehiculo); // POST
    void deleteVehiculo(Long id);


}
