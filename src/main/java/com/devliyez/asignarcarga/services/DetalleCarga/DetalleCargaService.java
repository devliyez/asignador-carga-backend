package com.devliyez.asignarcarga.services.DetalleCarga;

import com.devliyez.asignarcarga.dto.DetalleCargaRequest;
import com.devliyez.asignarcarga.dto.DetallecargaResponse;

import java.util.List;

public interface DetalleCargaService {


    List<DetallecargaResponse> getDetallesCargaById(Long cargaId);
    DetallecargaResponse postDetalleACarga(Long cargaId, DetalleCargaRequest dto);
    DetallecargaResponse updateDetalleCarga(Long id, DetalleCargaRequest dto);
    void deleteDetalleCarga (Long id);
}
