package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.DetalleCarga;
import lombok.Data;

@Data
public class DetallecargaResponse {

    private Long id;
    private String producto;
    private Integer cantidad;
    private Double peso;
    private Double volumen;

    public DetallecargaResponse(DetalleCarga detalleCarga) {
        this.producto = detalleCarga.getProducto();
        this.cantidad = detalleCarga.getCantidad();
        this.peso = detalleCarga.getPeso();
        this.volumen = detalleCarga.getVolumen();
    }
}
