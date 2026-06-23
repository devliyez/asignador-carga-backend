package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.TransportistaRegistrar;
import com.devliyez.asignarcarga.dto.TransportistaRequest;
import com.devliyez.asignarcarga.dto.TransportistaResponse;
import com.devliyez.asignarcarga.services.Transportista.TransportistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/transportista")
public class TransportistaController {

    private final TransportistaService transportistaService;

    @GetMapping
    public List<TransportistaResponse> getTransportistas(){
        return transportistaService.getTransportistas();
    }

    @GetMapping("/{id}")
    public TransportistaResponse getTransportistaById(Long id){
        return transportistaService.getTransportistaById(id);
    }

    @PostMapping("/crear")
    public TransportistaResponse postTransportista(TransportistaRegistrar t){
        return transportistaService.postTransportista(t);
    }

    @PutMapping("/actualizar/{id}")
    public TransportistaResponse updateTransportista(TransportistaRequest t, Long id){
        return transportistaService.updateTransportista(t,id);
    }

    @DeleteMapping("/eliminar")
    public void deleteTransportista(Long id){
        transportistaService.deleteTransportista(id);
    }

}
