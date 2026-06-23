package com.devliyez.asignarcarga.dto;

import lombok.Data;

@Data
public class VehiculoRequest {

    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean disponible;
    private Boolean habilitado;


}
