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
public class AsignacionServiceImpl {

    private final AsignacionRepository asignacionRepository;
    private final ClienteRepository clienteRepository;
    private final CargaRepository cargaRepository;

    public List<AsignacionResponse> getAsignacionById(Long id){

//        Carga carga = cargaRepository.findById(id).orElseThrow( () ->
//                new EntityNotFoundException("No encontrado"));



        Asignacion asignaciones = asignacionRepository.findByCargaId(id);

        List<AsignacionResponse> asignacionesrpta;
        asignacionesrpta = new ArrayList<>((Collection) asignaciones);

        return asignacionesrpta;
    }
}
