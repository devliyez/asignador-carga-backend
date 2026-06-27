package com.devliyez.asignarcarga.services.DetalleCarga;

import com.devliyez.asignarcarga.dto.DetalleCargaRequest;
import com.devliyez.asignarcarga.dto.DetallecargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.model.DetalleCarga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import com.devliyez.asignarcarga.repository.DetalleCargaRepository;
import com.devliyez.asignarcarga.services.DetalleCarga.CotizacionCalculos;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        //ID de la Carga
        Carga carga = cargaRepository.findById(cargaId)
                .orElseThrow(() -> new EntityNotFoundException("Carga no encontrada"));


        DetalleCarga detalle = new DetalleCarga();
        detalle.setProducto(dto.getProducto());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPeso(dto.getPeso());
        detalle.setVolumen(dto.getVolumen());
        detalle.setCarga(carga);

        DetalleCarga detalleGuardado = detalleCargaRepository.save(detalle);

        // ASIGNAR PESOS Y VOLUMEN

        List<DetalleCarga> detalles_carga = detalleCargaRepository.findByCargaId(cargaId);

        List<Double> pesos_total = new ArrayList<>();
        List<Double> volumen_total = new ArrayList<>();

        for(Integer i = 0; i < detalles_carga.size() ;i++){
            pesos_total.add(detalles_carga.get(i).getPeso());
        }

        for(Integer i = 0 ; i <detalles_carga.size() ; i++){
            volumen_total.add(detalles_carga.get(i).getVolumen());
        }




        CotizacionCalculos calculo = new CotizacionCalculos();
        List<Double> valores = calculo.valoresTotales(pesos_total, volumen_total);

        System.out.println("Valores de peso y volumen" + valores);

        carga.setVolumen(valores.get(0));
        carga.setPeso(valores.get(1));

//        carga.setPeso(carga.getPeso() + (dto.getPeso() * dto.getCantidad()));
//        carga.setVolumen(carga.getVolumen() + (dto.getVolumen() * dto.getCantidad()));

        //Dependiendo de como se carguen los detalles de la carga podria incurrir
        //en multiples peticiones a la vez.

        cargaRepository.save(carga);

        return new DetallecargaResponse(detalleGuardado);
    }



    @Override
    @Transactional
    public DetallecargaResponse updateDetalleCarga(Long id, DetalleCargaRequest dto) {

        // ID del Detalle Carga
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
