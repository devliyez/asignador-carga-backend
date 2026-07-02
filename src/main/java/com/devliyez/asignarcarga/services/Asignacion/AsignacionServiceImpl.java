package com.devliyez.asignarcarga.services.Asignacion;

import com.devliyez.asignarcarga.dto.AsignacionResponse;
import com.devliyez.asignarcarga.model.Asignacion;
import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.repository.AsignacionRepository;
import com.devliyez.asignarcarga.repository.CargaRepository;
import com.devliyez.asignarcarga.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionServiceImpl implements AsignacionService{

    private final AsignacionRepository asignacionRepository;

    public AsignacionResponse getAsignacionById(Long id){


        Asignacion asignaciones =asignacionRepository.findByCargaId(id);

        if(asignaciones == null){
            throw new EntityNotFoundException("Asignacion no encontrada.");
        }


        return new AsignacionResponse(asignaciones);
    }
}
