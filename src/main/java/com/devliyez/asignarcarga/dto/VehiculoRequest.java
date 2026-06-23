package com.devliyez.asignarcarga.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequest {

    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean disponible;
    private Boolean habilitado;


}
