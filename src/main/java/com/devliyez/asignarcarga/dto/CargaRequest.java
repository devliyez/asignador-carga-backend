package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Cliente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CargaRequest {

    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaRecojo;
    private Double peso;
    private Double volumen;
    private String origen;
    private String destino;
    private String descripcion;
    private Double cotizacion;
    private String estado;
    private Boolean habilitado;
    private Cliente cliente;

}
