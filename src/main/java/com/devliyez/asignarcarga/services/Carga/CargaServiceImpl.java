package com.devliyez.asignarcarga.services.Carga;


import com.devliyez.asignarcarga.dto.CargaRequest;
import com.devliyez.asignarcarga.dto.CargaResponse;
import com.devliyez.asignarcarga.model.*;
import com.devliyez.asignarcarga.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargaServiceImpl implements CargaService {

    private final CargaRepository cargaRepository;
    private final TransportistaRepository transportistaRepository;
    private final VehiculoRepository vehiculoRepository;
    private final AsignacionRepository asignacionRepository;
    private final ClienteRepository clienteRepository;


    @Override
    public List<CargaResponse> getCarga() {
        return cargaRepository.findAll()
                .stream()
                .map(CargaResponse::new)
                .toList();
    }

    @Override
    public CargaResponse getCargaById(Long id){

        Carga carga = cargaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No encontrado"));

        return new CargaResponse(carga);
    }

    @Override
    @Transactional
    public CargaResponse postCarga(CargaRequest carga) {

        Carga c = new Carga();


        c.setFechaRegistro(carga.getFechaRegistro());
        c.setDestino(carga.getDestino());
        c.setOrigen(carga.getOrigen());
        c.setPeso(0.0);
        c.setVolumen(0.0);
        c.setDescripcion(carga.getDescripcion());
        c.setCotizacion(0.0);
        c.setEstado("PENDIENTE");

        Cliente cliente = clienteRepository.findById(carga.getClienteId())
                        .orElseThrow(() -> new EntityNotFoundException(""));
        c.setCliente(cliente);
        c.setHabilitado(true);
        cargaRepository.save(c);

        return new CargaResponse(c);
    }

    @Override
    @Transactional
    public CargaResponse updateCarga(CargaRequest carga, Long id) {

        Carga c = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("Carga no encontrada"));

        c.setOrigen(carga.getOrigen());
        c.setDestino(carga.getDestino());
        c.setDescripcion(carga.getDescripcion());



        Cliente cliente = clienteRepository.findById(carga.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException(""));
        c.setCliente(cliente);

        // Cliente no modifica Habilitado, Cotizacion y Fecharegistro
        cargaRepository.save(c);

        return new CargaResponse(c);
    }

    @Override
    public void deleteCargaById(Long id) {

        Carga carga = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        carga.setHabilitado(false);


    }

    @Override
    @Transactional
    public void aprobarCarga(Long cargaid){

        //Verify if the Carga exists
         Carga carga = cargaRepository.findById(cargaid)
                 .orElseThrow(() -> new EntityNotFoundException("Carga no encontrada"));

         //Find Transportista and Vehiculo Disponible

        Transportista transportista = transportistaRepository.findFirstByDisponibleTrue();
        Vehiculo vehiculo = vehiculoRepository.findFirstByDisponibleTrue();

        if(transportista == null){
            throw new EntityNotFoundException("No se encontró un transportista disponible");
        }

        if (vehiculo == null){
            throw new EntityNotFoundException("No se encontró un vehiculo disponible");
        }

        //Set asignacion
        Asignacion asignacion = new Asignacion();
        asignacion.setCarga(carga);
        asignacion.setVehiculo(vehiculo);
        asignacion.setTransportista(transportista);

        //Cambios
        transportista.setDisponible(false);
        vehiculo.setDisponible(false);
        carga.setEstado("ASIGNADO");

        transportistaRepository.save(transportista);
        vehiculoRepository.save(vehiculo);
        cargaRepository.save(carga);
        asignacionRepository.save(asignacion);

        System.out.println("Asignacion: " + asignacion);

    }

    @Override
    @Transactional
    public void entregarCarga(Long cargaid){


        //Cambio al estado de la carga

        Carga carga = cargaRepository.findById(cargaid)
                .orElseThrow(() -> new EntityNotFoundException("Carga no encontrada"));

        carga.setEstado("ENTREGADO");
        cargaRepository.save(carga);
        // Estado de Transportista y Vehiculo

        Asignacion asignacion = asignacionRepository.findByCargaId(cargaid);

        asignacion.getVehiculo().setDisponible(true);
        asignacion.getTransportista().setDisponible(true);

        asignacionRepository.save(asignacion);
        vehiculoRepository.save(asignacion.getVehiculo());
        transportistaRepository.save(asignacion.getTransportista());
    }



}
