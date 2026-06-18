package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Carga;
import com.devliyez.asignarcarga.model.Cliente;
import com.devliyez.asignarcarga.model.DetalleCarga;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class cargaResponse {

    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaRecojo;
    private Integer peso;
    private String volumen;
    private String origen;
    private String destino;
    private String descripcion;
    private Double cotizacion;
    private String estado;
    private Cliente cliente;
    //Aqui evito los Detalles

    public cargaResponse(Carga carga) {

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
