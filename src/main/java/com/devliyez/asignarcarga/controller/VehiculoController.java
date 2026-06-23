package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.VehiculoRequest;
import com.devliyez.asignarcarga.dto.VehiculoResponse;
import com.devliyez.asignarcarga.services.Vehiculo.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    @GetMapping
    public List<VehiculoResponse> getVehiculos(){

        return vehiculoService.getVehiculos();
    }

    @GetMapping("/{id}")
    public VehiculoResponse getVehiculoById(Long id){
        return vehiculoService.getVehiculoById(id);
    }

    @PostMapping("/crear")
    public VehiculoResponse postVehiculo(VehiculoRequest vehiculoRequest){
        return vehiculoService.postVehiculo(vehiculoRequest);
    }

    @PutMapping("/actualizar/{id}")
    public VehiculoResponse updateVehiculo(VehiculoRequest v , Long id){
        return vehiculoService.updateVehiculo(v,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteVehiculo(Long id){
        vehiculoService.deleteVehiculo(id);
    }

}
