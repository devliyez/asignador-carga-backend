package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.AsignacionResponse;
import com.devliyez.asignarcarga.services.Asignacion.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asignacion")
@RequiredArgsConstructor
public class AsignacionController {

    private final AsignacionService asignacionService;

    @GetMapping("/{id}")
    public AsignacionResponse getAsignacionById(@PathVariable Long id){
        return asignacionService.getAsignacionById(id);
    }

}
