package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.dto.VehiculoRequest;
import com.devliyez.asignarcarga.dto.VehiculoResponse;

import java.util.List;

public interface VehiculoService {


    List<VehiculoResponse> getVehiculos (); //GET
    VehiculoResponse getVehiculoById(Long id); //GET por ID
    VehiculoResponse updateVehiculo(VehiculoRequest vehiculo, Long id); // EDITAR
    VehiculoResponse postVehiculo(VehiculoRequest vehiculo); // POST
    void deleteVehiculo(Long id);


}
