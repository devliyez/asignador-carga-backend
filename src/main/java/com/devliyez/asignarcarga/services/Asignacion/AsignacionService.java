package com.devliyez.asignarcarga.services.Asignacion;

import com.devliyez.asignarcarga.dto.AsignacionResponse;

import java.util.List;

public interface AsignacionService {

    List<AsignacionResponse> getAsignacionById(Long id);


}
