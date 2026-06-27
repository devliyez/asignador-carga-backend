package com.devliyez.asignarcarga.dto;

import lombok.Data;

@Data
public class DetalleCargaRequest {

    private String producto;
    private Integer cantidad;
    private Double peso; //KG
    private Double volumen;
}
