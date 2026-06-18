package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.transportistaRegistrar;
import com.devliyez.asignarcarga.dto.transportistaRequest;
import com.devliyez.asignarcarga.dto.transportistaResponse;
import com.devliyez.asignarcarga.model.Transportista;

import java.util.List;
import java.util.Optional;

public interface TransportistaService {


    List<transportistaResponse> getTransportistas();
    transportistaResponse getTransportistaById(Long id);
    transportistaResponse postTransportista(transportistaRegistrar dto);
    transportistaResponse updateTransportista(transportistaRequest transportista, Long id);
    void deleteTransportista(Long id);
}
