package com.devliyez.backend.controller;

import com.devliyez.backend.dto.VehiculoRequest;
import com.devliyez.backend.dto.VehiculoResponse;
import com.devliyez.backend.service.Vehiculo.VehiculoService;
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
    public VehiculoResponse getVehiculoById(@PathVariable Long id){
        return vehiculoService.getVehiculoById(id);
    }

    @PostMapping("/crear")
    public VehiculoResponse postVehiculo(@RequestBody VehiculoRequest vehiculoRequest){
        System.out.println("Desde el Controller" + vehiculoRequest);
        return vehiculoService.postVehiculo(vehiculoRequest);
    }

    @PutMapping("/actualizar/{id}")
    public VehiculoResponse updateVehiculo(@RequestBody VehiculoRequest v ,@PathVariable Long id){
        return vehiculoService.updateVehiculo(v,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteVehiculo(@PathVariable Long id){
        vehiculoService.deleteVehiculo(id);
    }

}
