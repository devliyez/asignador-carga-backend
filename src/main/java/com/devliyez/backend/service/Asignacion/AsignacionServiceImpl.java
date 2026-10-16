package com.devliyez.backend.service.Asignacion;

import com.devliyez.backend.dto.AsignacionResponse;
import com.devliyez.backend.model.Asignacion;
import com.devliyez.backend.repository.AsignacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
