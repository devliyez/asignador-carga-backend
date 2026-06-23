package com.devliyez.asignarcarga.services.Carga;

import com.devliyez.asignarcarga.dto.CargaRequest;
import com.devliyez.asignarcarga.dto.CargaResponse;

import java.util.List;


public interface CargaService {

    List<CargaResponse> getCarga();
    CargaResponse getCargaById(Long id);
    CargaResponse postCarga(CargaRequest carga);
    CargaResponse updateCarga(CargaRequest carga, Long id);
    void deleteCargaById(Long id);

}
