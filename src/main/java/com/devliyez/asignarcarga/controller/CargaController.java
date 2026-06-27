package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.CargaRequest;
import com.devliyez.asignarcarga.dto.CargaResponse;
import com.devliyez.asignarcarga.services.Carga.CargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carga")
@RequiredArgsConstructor
public class CargaController {

    private final CargaService cargaService;

    @GetMapping
    public List<CargaResponse> getCarga(){
        return cargaService.getCarga();
    }

    @GetMapping("/{id}")
    public CargaResponse getCargaById(@PathVariable Long id){
        return cargaService.getCargaById(id);
    }

    @PostMapping("/crear")
    public CargaResponse postCarga(@RequestBody CargaRequest c){
        return cargaService.postCarga(c);
    }

    @PutMapping("/actualizar/{id}")
    public CargaResponse updateCarga(@RequestBody CargaRequest c,@PathVariable Long id){
        return cargaService.updateCarga(c,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCargaById(@PathVariable Long id){
        cargaService.deleteCargaById(id);
    }

}
