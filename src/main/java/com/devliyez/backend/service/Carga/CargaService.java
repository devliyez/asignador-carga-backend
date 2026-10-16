package com.devliyez.backend.service.Carga;

import com.devliyez.backend.dto.CargaRequest;
import com.devliyez.backend.dto.CargaResponse;

import java.util.List;

public interface CargaService {

    List<CargaResponse> getCargas();
    CargaResponse getCarga(Long id);
    CargaResponse postCarga (CargaRequest carga);
    CargaResponse putCarga (CargaRequest carga, Long id);
    void deleteCarga(Long id);

    void envioCarga(Long id);
    void entregaCarga(Long id);
}
