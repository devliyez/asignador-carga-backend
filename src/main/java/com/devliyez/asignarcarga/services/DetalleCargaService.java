package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.DetalleCargaRequest;
import com.devliyez.asignarcarga.dto.DetallecargaResponse;
import com.devliyez.asignarcarga.model.DetalleCarga;

import java.util.List;

public interface DetalleCargaService {


    List<DetalleCarga> getDetallesCargaById(Long cargaId);
    DetallecargaResponse postDetalleACarga(Long cargaId, DetalleCargaRequest dto);
    DetallecargaResponse updateDetalleCarga(Long id, DetalleCargaRequest dto);
    void deleteDetalleCarga (Long id);
}
