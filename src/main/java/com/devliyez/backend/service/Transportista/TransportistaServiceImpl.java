package com.devliyez.backend.service.Transportista;

import com.devliyez.backend.dto.TransportistaDTO.TransportistaRegistrar;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaRequest;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaResponse;
import com.devliyez.backend.model.Transportista;
import com.devliyez.backend.repository.TransportistaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransportistaServiceImpl implements TransportistaService {

    private final TransportistaRepository transportistaRepository;


    @Override
    public List<TransportistaResponse> getTransportistas(){
        return transportistaRepository.findAll()
                .stream()
                .filter(t -> t.getHabilitado().equals(true))
                .map(TransportistaResponse :: new)
                .toList();
    }

    @Override
    public TransportistaResponse getTransportistaById(Long id) {

        Transportista t = transportistaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Transportista no encontrado"));

        return new TransportistaResponse(t);
    }

    @Override
    public TransportistaResponse postTransportista(TransportistaRequest dto ) {



        Transportista transportista = new Transportista();
        transportista.setNombre(dto.getNombre());
        transportista.setDisponible(true);
        transportista.setHabilitado(true);

        return new TransportistaResponse(transportistaRepository.save(transportista));
    }

    @Override
    public TransportistaResponse updateTransportista(TransportistaRequest transportista, Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportista no encontrado"));

        t.setNombre(transportista.getNombre());
        t.setDisponible(transportista.getDisponible());

        transportistaRepository.save(t);

        return new TransportistaResponse(t);
    }

    @Override
    public void deleteTransportista(Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));


        t.setHabilitado(false);
        transportistaRepository.save(t);



    }


}
