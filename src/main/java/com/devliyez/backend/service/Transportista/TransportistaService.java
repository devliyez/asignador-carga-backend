package com.devliyez.backend.service.Transportista;

import com.devliyez.backend.dto.TransportistaDTO.TransportistaRegistrar;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaRequest;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaResponse;

import java.util.List;

public interface TransportistaService {


    List<TransportistaResponse> getTransportistas();
    TransportistaResponse getTransportistaById(Long id);
    TransportistaResponse postTransportista(TransportistaRequest dto);
    TransportistaResponse updateTransportista(TransportistaRequest transportista, Long id);
    void deleteTransportista(Long id);
}
