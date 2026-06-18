package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.transportistaResponse;
import com.devliyez.asignarcarga.dto.vehiculoRequest;
import com.devliyez.asignarcarga.dto.vehiculoResponse;
import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Vehiculo;
import com.devliyez.asignarcarga.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService{

    private final VehiculoRepository vehiculoRepository;


    // GET TODOS
    @Override
    public List<vehiculoResponse> getVehiculos(){
        return vehiculoRepository.findAll()
                .stream()
                .map(vehiculoResponse ::new)
                .toList();
    }

    //GET VEHICULO POR ID
    public vehiculoResponse getVehiculoById(Long id){

        Vehiculo v = vehiculoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return new vehiculoResponse(v);
    }

    //POST VEHICULO
    public vehiculoResponse postVehiculo(vehiculoRequest vehiculo){

        if(vehiculo.getEstado() == null || vehiculo.getPlaca().equals("") || vehiculo.getVolumen_max() == null || vehiculo.getPeso_max() == null
        ){
            throw new RuntimeException("No puede haber datos vacios");
        }

        Vehiculo v = new Vehiculo();

        v.setVolumen_max(vehiculo.getVolumen_max());
        v.setEstado(vehiculo.getEstado());
        v.setPlaca(vehiculo.getPlaca());
        v.setHabilitado(vehiculo.getHabilitado());
        v.setPeso_max(vehiculo.getPeso_max());

        vehiculoRepository.save(v);


        return new vehiculoResponse(v);
    }

    public vehiculoResponse updateVehiculo(vehiculoRequest vehiculo, Long id){

        Vehiculo v = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        v.setEstado(vehiculo.getEstado());
        v.setPlaca(vehiculo.getPlaca());
        v.setHabilitado(vehiculo.getHabilitado());
        v.setPeso_max(vehiculo.getPeso_max());
        v.setVolumen_max(vehiculo.getVolumen_max());

        vehiculoRepository.save(v);

        return new vehiculoResponse(v);
    }

    public void deleteVehiculo(Long id){

        Vehiculo v = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        v.setHabilitado(false);
    }

}
