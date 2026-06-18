package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.dto.cargaRequest;
import com.devliyez.asignarcarga.dto.cargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargaServiceImpl implements CargaService {

    private final CargaRepository cargaRepository;


    @Override
    public List<cargaResponse> getCarga() {
        return cargaRepository.findAll()
                .stream()
                .map(cargaResponse::new)
                .toList();
    }

    @Override
    public cargaResponse getCargaById(Long id){

        Carga carga = cargaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No encontrado"));

        return new cargaResponse(carga);
    }

    @Override
    public cargaResponse postCarga(cargaRequest carga) {

        Carga c = new Carga();

        c.setFechaRecojo(carga.getFechaRecojo());
        c.setFechaRegistro(carga.getFechaRegistro());
        c.setDestino(carga.getDestino());
        c.setOrigen(carga.getOrigen());
        c.setPeso(carga.getPeso());
        c.setVolumen(carga.getVolumen());
        c.setDescripcion(carga.getDescripcion());
        c.setCotizacion(carga.getCotizacion());
        c.setEstado(carga.getEstado());
        c.setCliente(carga.getCliente());

        c.setHabilitado(true);
        cargaRepository.save(c);

        return new cargaResponse(c);
    }

    @Override
    public cargaResponse updateCarga(cargaRequest carga, Long id) {

        Carga c = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("Carga no encontrada"));

        c.setFechaRecojo(carga.getFechaRecojo());
        c.setPeso(carga.getPeso());
        c.setVolumen(carga.getVolumen());
        c.setOrigen(carga.getOrigen());
        c.setCotizacion(carga.getCotizacion());
        c.setDestino(carga.getDestino());
        c.setDescripcion(carga.getDescripcion());
        c.setFechaRegistro(carga.getFechaRegistro());
        c.setHabilitado(carga.getHabilitado());
        c.setEstado(carga.getEstado());

        cargaRepository.save(c);

        return new cargaResponse(c);
    }

    @Override
    public void deleteCargaById(Long id) {

        Carga carga = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        carga.setHabilitado(false);


    }


}
