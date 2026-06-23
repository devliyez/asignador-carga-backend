package com.devliyez.asignarcarga.services.Vehiculo;

import com.devliyez.asignarcarga.dto.VehiculoRequest;
import com.devliyez.asignarcarga.dto.VehiculoResponse;
import com.devliyez.asignarcarga.model.Vehiculo;
import com.devliyez.asignarcarga.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;


    // GET TODOS
    @Override
    public List<VehiculoResponse> getVehiculos(){
        return vehiculoRepository.findAll()
                .stream()
                .map(VehiculoResponse::new)
                .toList();
    }

    //GET VEHICULO POR ID
    public VehiculoResponse getVehiculoById(Long id){

        Vehiculo v = vehiculoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return new VehiculoResponse(v);
    }

    //POST VEHICULO
    public VehiculoResponse postVehiculo(VehiculoRequest vehiculo){

        if(vehiculo.getDisponible() == null || vehiculo.getPlaca().equals("") || vehiculo.getVolumen_max() == null || vehiculo.getPeso_max() == null
        ){
            throw new RuntimeException("No puede haber datos vacios");
        }

        Vehiculo v = new Vehiculo();

        v.setVolumen_max(vehiculo.getVolumen_max());
        v.setDisponible(vehiculo.getDisponible());
        v.setPlaca(vehiculo.getPlaca());
        v.setHabilitado(vehiculo.getHabilitado());
        v.setPeso_max(vehiculo.getPeso_max());

        vehiculoRepository.save(v);


        return new VehiculoResponse(v);
    }

    public VehiculoResponse updateVehiculo(VehiculoRequest vehiculo, Long id){

        Vehiculo v = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        v.setDisponible(vehiculo.getDisponible());
        v.setPlaca(vehiculo.getPlaca());
        v.setHabilitado(vehiculo.getHabilitado());
        v.setPeso_max(vehiculo.getPeso_max());
        v.setVolumen_max(vehiculo.getVolumen_max());

        vehiculoRepository.save(v);

        return new VehiculoResponse(v);
    }

    public void deleteVehiculo(Long id){

        Vehiculo v = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        v.setHabilitado(false);
    }

}
