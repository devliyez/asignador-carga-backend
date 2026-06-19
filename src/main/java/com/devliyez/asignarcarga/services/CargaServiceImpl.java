package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.dto.CargaRequest;
import com.devliyez.asignarcarga.dto.CargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CargaServiceImpl implements CargaService {

    private final CargaRepository cargaRepository;


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
    public CargaResponse postCarga(CargaRequest carga) {

        Carga c = new Carga();

        c.setFechaRecojo(carga.getFechaRecojo());
        c.setFechaRegistro(carga.getFechaRegistro());
        c.setDestino(carga.getDestino());
        c.setOrigen(carga.getOrigen());
        c.setPeso(0.0);
        c.setVolumen(0.0);
        c.setDescripcion(carga.getDescripcion());
        c.setCotizacion(0.0);
        c.setEstado("PENDIENTE");
        c.setCliente(carga.getCliente());

        c.setHabilitado(true);
        cargaRepository.save(c);

        return new CargaResponse(c);
    }

    @Override
    public CargaResponse updateCarga(CargaRequest carga, Long id) {

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

        return new CargaResponse(c);
    }

    @Override
    public void deleteCargaById(Long id) {

        Carga carga = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        carga.setHabilitado(false);


    }


}
