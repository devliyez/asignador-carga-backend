package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.TransportistaRegistrar;
import com.devliyez.asignarcarga.dto.TransportistaRequest;
import com.devliyez.asignarcarga.dto.TransportistaResponse;

import java.util.List;

public interface TransportistaService {


    List<TransportistaResponse> getTransportistas();
    TransportistaResponse getTransportistaById(Long id);
    TransportistaResponse postTransportista(TransportistaRegistrar dto);
    TransportistaResponse updateTransportista(TransportistaRequest transportista, Long id);
    void deleteTransportista(Long id);
}
