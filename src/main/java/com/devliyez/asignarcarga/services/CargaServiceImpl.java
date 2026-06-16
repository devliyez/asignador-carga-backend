package com.devliyez.asignarcarga.services;


import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CargaServiceImpl implements CargaService {

    private final CargaRepository cargaRepository;


    @Override
    public List<Carga> getCarga() {
        return cargaRepository.findAll();
    }

    @Override
    public Optional<Carga> getCargaById(Long id){
        return cargaRepository.findById(id);
    }

    @Override
    public Carga postCarga(Carga carga) {


        carga.setHabilitado(true);

        return cargaRepository.save(carga);
    }

    @Override
    public Carga updateCarga(Carga carga, Long id) {

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

        return cargaRepository.save(c);
    }

    @Override
    public void deleteCargaById(Long id) {

        Carga carga = cargaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        carga.setHabilitado(false);


    }


}
