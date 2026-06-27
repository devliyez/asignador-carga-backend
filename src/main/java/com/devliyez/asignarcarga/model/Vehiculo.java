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
    private Double peso_max;//EN KG
    private Double volumen_max;//EN KG
    private String placa;
    private Boolean disponible;
    private Boolean habilitado;
}
