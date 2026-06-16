package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CargaService {

    List<Carga> getCarga();
    Optional<Carga> getCargaById(Long id);
    Carga postCarga(Carga carga);
    Carga updateCarga(Carga carga, Long id);
    void deleteCargaById(Long id);

}
