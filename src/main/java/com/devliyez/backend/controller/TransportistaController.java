package com.devliyez.backend.controller;

import com.devliyez.backend.dto.TransportistaDTO.TransportistaRegistrar;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaRequest;
import com.devliyez.backend.dto.TransportistaDTO.TransportistaResponse;
import com.devliyez.backend.service.Transportista.TransportistaService;
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
    public TransportistaResponse getTransportistaById(@PathVariable Long id){
        return transportistaService.getTransportistaById(id);
    }

    @PostMapping("/crear")
    public TransportistaResponse postTransportista(@RequestBody TransportistaRequest t){
        return transportistaService.postTransportista(t);
    }

    @PutMapping("/actualizar/{id}")
    public TransportistaResponse updateTransportista(@RequestBody TransportistaRequest t,@PathVariable Long id){
        return transportistaService.updateTransportista(t,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteTransportista(@PathVariable Long id){
        transportistaService.deleteTransportista(id);
    }

}
