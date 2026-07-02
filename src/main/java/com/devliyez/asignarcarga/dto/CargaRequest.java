package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Cliente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CargaRequest {

    private String origen;
    private String destino;
    private String descripcion;
    private Long clienteId;

}
