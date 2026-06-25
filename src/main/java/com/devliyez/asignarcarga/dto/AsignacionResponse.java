package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Asignacion;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AsignacionResponse {

    private Long id;
    private String cliente;
    private String transportista;
    private String vehiculo;
    private String carga;
    private LocalDateTime fechaRegistro;
    private String estado;

    public AsignacionResponse(Asignacion asignacion) {
        this.id = asignacion.getId();
        this.cliente = asignacion.getCarga().getCliente().getNombre();
        this.transportista = asignacion.getTransportista().getNombre();
        this.vehiculo = asignacion.getVehiculo().getPlaca();
        this.carga = asignacion.getCarga().getDestino();
        this.fechaRegistro = asignacion.getFechaRegistro();
        this.estado = asignacion.getCarga().getEstado();
    }
}
