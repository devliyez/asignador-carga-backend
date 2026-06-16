package com.devliyez.asignarcarga.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "detallecarga")
public class DetalleCarga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String producto; // Ej: "Papas", "Plásticos"

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double peso; // Peso de este ítem en KG

    @Column(nullable = false)
    private Double volumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carga_id", nullable = false) // Columna FK en PostgreSQL
    private Carga carga;
}
