package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Vehiculo;
import com.devliyez.asignarcarga.repository.VehiculoRepository;
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
    public List<Vehiculo> getVehiculos(){
        return vehiculoRepository.findAll();
    }

    //GET VEHICULO POR ID
    public Optional<Vehiculo> getVehiculoById(Long id){
        return vehiculoRepository.findById(id);
    }

    //POST VEHICULO
    public Vehiculo postVehiculo(Vehiculo vehiculo){

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


        return vehiculoRepository.save(v);
    }

    public Vehiculo updateVehiculo(Vehiculo vehiculo, Long id){

        Vehiculo v = vehiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));

        v.setEstado(vehiculo.getEstado());
        v.setPlaca(vehiculo.getPlaca());
        v.setHabilitado(vehiculo.getHabilitado());
        v.setPeso_max(vehiculo.getPeso_max());
        v.setVolumen_max(vehiculo.getVolumen_max());

        return vehiculoRepository.save(v);
    }

    public void deleteVehiculo(Long id){

        Vehiculo v = vehiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        v.setHabilitado(false);
    }

}
