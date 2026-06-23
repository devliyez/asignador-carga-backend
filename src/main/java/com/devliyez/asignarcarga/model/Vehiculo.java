package com.devliyez.asignarcarga.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double peso_max;
    private Double volumen_max;
    private String placa;
    private Boolean disponible;
    private Boolean habilitado;
}
