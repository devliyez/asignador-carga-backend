package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.DetalleCargaRequest;
import com.devliyez.asignarcarga.dto.DetallecargaResponse;
import com.devliyez.asignarcarga.model.DetalleCarga;
import com.devliyez.asignarcarga.services.DetalleCarga.DetalleCargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallecarga")
@RequiredArgsConstructor
public class DetalleCargaController {

    private final DetalleCargaService detalleCargaService;

    @GetMapping
    public List<DetalleCarga> getDetallesCargaById(@PathVariable Long cargaid){

        return detalleCargaService.getDetallesCargaById(cargaid);
    }

    @PostMapping("/crear")
    public DetallecargaResponse postDetalleACarga(@PathVariable Long cargaid, @RequestBody DetalleCargaRequest dto){
        return detalleCargaService.postDetalleACarga(cargaid, dto);
    }

    @PutMapping("/actualizar/{id}")
    public DetallecargaResponse updateDetalleCarga(@PathVariable Long id, @RequestBody DetalleCargaRequest dto){
        return detalleCargaService.updateDetalleCarga(id,dto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteDetalleCarga(@PathVariable Long id){
        detalleCargaService.deleteDetalleCarga(id);
    }
}