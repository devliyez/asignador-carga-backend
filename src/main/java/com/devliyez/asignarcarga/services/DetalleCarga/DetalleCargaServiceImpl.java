package com.devliyez.asignarcarga.services.DetalleCarga;

import com.devliyez.asignarcarga.dto.DetalleCargaRequest;
import com.devliyez.asignarcarga.dto.DetallecargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.model.DetalleCarga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import com.devliyez.asignarcarga.repository.DetalleCargaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleCargaServiceImpl implements DetalleCargaService {

    private final DetalleCargaRepository detalleCargaRepository;
    private final CargaRepository cargaRepository;


    public List<DetalleCarga> getDetallesCargaById(Long cargaId){

        Carga c = cargaRepository.findById(cargaId).
                orElseThrow(() -> new EntityNotFoundException("No encontrado"));

        List<DetalleCarga> detalles = detalleCargaRepository.findByCargaId(cargaId);

        return detalles;

    }



    @Override
    @Transactional
    public DetallecargaResponse postDetalleACarga(Long cargaId, DetalleCargaRequest dto) {

        Carga carga = cargaRepository.findById(cargaId)
                .orElseThrow(() -> new EntityNotFoundException("Carga no encontrada"));


        DetalleCarga detalle = new DetalleCarga();
        detalle.setProducto(dto.getProducto());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPeso(dto.getPeso());
        detalle.setVolumen(dto.getVolumen());
        detalle.setCarga(carga);

        DetalleCarga detalleGuardado = detalleCargaRepository.save(detalle);

        carga.setPeso(carga.getPeso() + dto.getPeso());
        carga.setVolumen(carga.getVolumen() + dto.getVolumen());

        //Dependiendo de como se carguen los detalles de la carga podria incurrir
        //en multiples peticiones a la vez.

        cargaRepository.save(carga);

        return new DetallecargaResponse(detalleGuardado);
    }

    @Override
    @Transactional
    public DetallecargaResponse updateDetalleCarga(Long id, DetalleCargaRequest dto) {

        DetalleCarga detalle = detalleCargaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Detalle no encontrado"));

        Carga carga = detalle.getCarga();

        carga.setPeso(carga.getPeso() - detalle.getPeso());
        carga.setVolumen(carga.getVolumen() - detalle.getVolumen());

        detalle.setPeso(dto.getPeso());
        detalle.setVolumen(dto.getVolumen());
        detalle.setCantidad(dto.getCantidad());
        detalle.setProducto(dto.getProducto());
        DetalleCarga detalleActual = detalleCargaRepository.save(detalle);

        carga.setVolumen(carga.getVolumen() + detalleActual.getVolumen());
        carga.setPeso(carga.getPeso() + detalleActual.getPeso());
        cargaRepository.save(carga);

        return new DetallecargaResponse(detalleActual);

    }

    public void deleteDetalleCarga(Long id){

        DetalleCarga detalle = detalleCargaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Detalle no encontrado"));

        Carga carga = detalle.getCarga();

        carga.setVolumen(carga.getVolumen() - detalle.getVolumen());
        carga.setPeso(carga.getPeso() - detalle.getPeso());

        cargaRepository.save(carga);

        detalleCargaRepository.delete(detalle);



    }
}
