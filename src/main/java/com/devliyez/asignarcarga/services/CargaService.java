package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.cargaRequest;
import com.devliyez.asignarcarga.dto.cargaResponse;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.CargaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CargaService {

    List<cargaResponse> getCarga();
    cargaResponse getCargaById(Long id);
    cargaResponse postCarga(cargaRequest carga);
    cargaResponse updateCarga(cargaRequest carga, Long id);
    void deleteCargaById(Long id);

}
