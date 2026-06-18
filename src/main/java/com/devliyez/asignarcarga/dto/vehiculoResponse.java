package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Vehiculo;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class vehiculoResponse {

    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean estado;
    private Boolean habilitado;

    public vehiculoResponse(Vehiculo vehiculo) {
        this.peso_max = vehiculo.getPeso_max();
        this.volumen_max = vehiculo.getVolumen_max();
        this.placa = vehiculo.getPlaca();
        this.estado = vehiculo.getEstado();
        this.habilitado = vehiculo.getEstado();
    }
}
