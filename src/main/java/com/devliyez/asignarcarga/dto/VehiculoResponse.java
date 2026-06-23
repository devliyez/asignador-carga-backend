package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Vehiculo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class VehiculoResponse {

    private Long id;
    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean estado;
    private Boolean habilitado;

    public VehiculoResponse(Vehiculo vehiculo) {
        this.peso_max = vehiculo.getPeso_max();
        this.volumen_max = vehiculo.getVolumen_max();
        this.placa = vehiculo.getPlaca();
        this.estado = vehiculo.getDisponible();
        this.habilitado = vehiculo.getDisponible();
    }
}
