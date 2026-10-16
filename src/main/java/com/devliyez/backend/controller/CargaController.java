package com.devliyez.backend.controller;

import com.devliyez.backend.dto.CargaRequest;
import com.devliyez.backend.dto.CargaResponse;
import com.devliyez.backend.service.Carga.CargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carga")
public class CargaController {

    private final CargaService cargaService;

    @GetMapping
    public List<CargaResponse> getCargas(){
        return this.cargaService.getCargas();
    }

    @GetMapping("/{id}")
    public CargaResponse getCarga(@PathVariable Long id){
        return this.cargaService.getCarga(id);
    }

    @PostMapping("/crear")
    public CargaResponse postCarga (@RequestBody CargaRequest carga){
        return this.cargaService.postCarga(carga);
    }

    @PutMapping("/actualizar/{id}")
    public CargaResponse putCarga(@RequestBody CargaRequest carga, @PathVariable Long id){
        return this.cargaService.putCarga(carga,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCarga(@PathVariable Long id){
         this.cargaService.deleteCarga(id);
    }



}
