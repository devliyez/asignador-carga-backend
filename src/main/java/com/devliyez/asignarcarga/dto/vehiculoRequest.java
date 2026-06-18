package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Vehiculo;
import lombok.Data;

@Data
public class vehiculoRequest {

    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean estado;
    private Boolean habilitado;


}
