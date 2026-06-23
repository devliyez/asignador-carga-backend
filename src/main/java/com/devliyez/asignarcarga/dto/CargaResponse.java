package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.model.Cliente;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CargaResponse {

    private Long id;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaRecojo;
    private Double peso;
    private Double volumen;
    private String origen;
    private String destino;
    private String descripcion;
    private Double cotizacion;
    private String estado;
    private Cliente cliente;
    //Aqui evito los Detalles

    public CargaResponse(Carga carga) {

        this.fechaRecojo = carga.getFechaRecojo();
        this.fechaRegistro = carga.getFechaRegistro();
        this.peso = carga.getPeso();
        this.volumen = carga.getVolumen();
        this.origen = carga.getOrigen();
        this.destino = carga.getDestino();
        this.descripcion = carga.getDescripcion();
        this.cotizacion = carga.getCotizacion();
        this.estado = carga.getEstado();
        this.cliente = carga.getCliente();

    }
}
