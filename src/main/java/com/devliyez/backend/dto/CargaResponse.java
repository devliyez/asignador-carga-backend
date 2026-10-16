package com.devliyez.backend.dto;

import com.devliyez.backend.model.Carga;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CargaResponse {

    private String cliente;
    private String descripcion;
    private String detalles;
    private String origen;
    private String destino;
    private Double cotizacion;
    private LocalDateTime fechaRegistro;

    private String email;
    private String estado;
    private Boolean habilitado;


    public CargaResponse(Carga carga) {
        this.cliente = carga.getCliente();
        this.descripcion = carga.getDescripcion();
        this.detalles = carga.getDetalles();
        this.origen = carga.getOrigen();
        this.destino = carga.getDestino();
        this.cotizacion = carga.getCotizacion();
        this.fechaRegistro = carga.getFechaRegistro();
        this.email = carga.getEmail();
        this.estado = carga.getEstado();
        this.habilitado = carga.getHabilitado();
    }
}
