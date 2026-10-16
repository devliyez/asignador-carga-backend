package com.devliyez.backend.dto;

import lombok.Data;

@Data
public class CargaRequest {

    private String origen;
    private String destino;
    private String descripcion;
    private Long cliente;
    private String detalles;
    private Double cotizacion;
    private String email;
    private String estado;
    private Boolean habilitado;
}
