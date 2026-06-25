package com.devliyez.asignarcarga.services.Transportista;

import com.devliyez.asignarcarga.dto.TransportistaDTO.TransportistaRegistrar;
import com.devliyez.asignarcarga.dto.TransportistaDTO.TransportistaRequest;
import com.devliyez.asignarcarga.dto.TransportistaDTO.TransportistaResponse;

import java.util.List;

public interface TransportistaService {


    List<TransportistaResponse> getTransportistas();
    TransportistaResponse getTransportistaById(Long id);
    TransportistaResponse postTransportista(TransportistaRegistrar dto);
    TransportistaResponse updateTransportista(TransportistaRequest transportista, Long id);
    void deleteTransportista(Long id);
}
