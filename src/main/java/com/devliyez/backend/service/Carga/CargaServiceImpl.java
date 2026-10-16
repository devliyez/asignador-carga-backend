package com.devliyez.backend.service.Carga;

import com.devliyez.backend.dto.CargaRequest;
import com.devliyez.backend.dto.CargaResponse;
import com.devliyez.backend.model.Carga;
import com.devliyez.backend.repository.CargaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CargaServiceImpl implements CargaService {


    private final CargaRepository cargaRepository;

    @Override
    public List<CargaResponse> getCargas() {

        return cargaRepository.findAll()
                .stream()
                .map(CargaResponse::new)
                .toList();
    }

    @Override
    public CargaResponse getCarga(Long id) {
        Carga carga = cargaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("No encontrado"));

        return new CargaResponse(carga);
    }

    @Override
    public CargaResponse postCarga(CargaRequest carga) {
        Carga c = new Carga();


        c.setDestino(carga.getDestino());
        c.setOrigen(carga.getOrigen());
        c.setDescripcion(carga.getDescripcion());
        c.setCotizacion(0.0);
        c.setEstado("PENDIENTE");
        c.setHabilitado(true);
        cargaRepository.save(c);

        return new CargaResponse(c);
    }

    @Override
    @Transactional
    public CargaResponse putCarga(CargaRequest carga, Long id) {
        Carga c = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("Carga no encontrada"));

        if(c.getHabilitado() == false){
            throw new RuntimeException("No se puede modificar cargas no habilitadas");
        }

        c.setOrigen(carga.getOrigen());
        c.setDestino(carga.getDestino());
        c.setDescripcion(carga.getDescripcion());
        c.setDetalles(carga.getDetalles());
        c.setCotizacion(carga.getCotizacion());
        c.setEmail(carga.getEmail());

        if(Objects.equals(carga.getEstado(), "")){
            if(carga.getCotizacion() == null || carga.getCotizacion() == 0.0 ){
                throw new RuntimeException("No se puede cambiar el estado mientras no se tenga la Cotización");
            }
        }

        c.setHabilitado(carga.getHabilitado());

        cargaRepository.save(c);

        return new CargaResponse(c);
    }

    @Override
    public void deleteCarga(Long id) {

        Carga c = cargaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El id"+ id +" no fue encontrado"));

        c.setEstado("CANCELADO");
        c.setHabilitado(false);

        cargaRepository.save(c);

    }

    @Override
    public void envioCarga(Long id) {

        Carga c = cargaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El id"+ id +" no fue encontrado"));

        if (c.getHabilitado() == false){
            throw new RuntimeException("No se puede modificar una carga cancelada. ");
        }
        c.setEstado("EN ENVIO");

    }

    @Override
    public void entregaCarga(Long id) {

        Carga c = cargaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El id"+ id +" no fue encontrado"));

        if (c.getHabilitado() == false){
            throw new RuntimeException("No se puede modificar una carga cancelada. ");
        }
        if(!Objects.equals(c.getEstado(), "EN ENVIO")){
            throw new RuntimeException("La carga debe de estar 'En Envio'.");

        }
        c.setEstado("ENTREGADO");
        c.setHabilitado(false);

    }


}
