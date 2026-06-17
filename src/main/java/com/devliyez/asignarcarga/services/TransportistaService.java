package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.transportistaRegistrar;
import com.devliyez.asignarcarga.model.Transportista;

import java.util.List;
import java.util.Optional;

public interface TransportistaService {


    List<Transportista> getTransportistas();
    Optional<Transportista> getTransportistaById(Long id);
    Transportista postTransportista(transportistaRegistrar dto);
    Transportista updateTransportista(Transportista transportista, Long id);
    void deleteTransportista(Long id);
}
