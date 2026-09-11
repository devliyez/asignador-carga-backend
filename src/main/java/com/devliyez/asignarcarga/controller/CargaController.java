package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.CargaRequest;
import com.devliyez.asignarcarga.dto.CargaResponse;
import com.devliyez.asignarcarga.services.Carga.CargaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carga")
public class CargaController {

    private final CargaService cargaService;

    public CargaController(CargaService cargaService) {
        this.cargaService = cargaService;
    }

    @GetMapping
    public List<CargaResponse> getCarga(){
        return cargaService.getCarga();
    }

    @GetMapping("/{id}")
    public CargaResponse getCargaById(@PathVariable Long id){
        return cargaService.getCargaById(id);
    }

    @GetMapping("/cliente/{id}")
    public List<CargaResponse> getCargaByClienteId(@PathVariable Long id){
        return cargaService.getCargaByClienteUsuarioId(id);
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

    @PutMapping("/aprobar/{id}")
    public void aprobarCarga(@PathVariable Long id){
        cargaService.aprobarCarga(id);
    }

    @PutMapping("/entregar/{id}")
    public void entregarCarga(@PathVariable Long id){
        cargaService.entregarCarga(id);
    }

}
