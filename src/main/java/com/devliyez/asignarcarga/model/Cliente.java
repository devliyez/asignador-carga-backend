package com.devliyez.asignarcarga.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "usuario_id")
    private Long usuarioId; // JPA llenará este campo automáticamente usando el ID del usuario

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // Crucial: Le dice a JPA que comparta la PK con la entidad Usuario
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String nombre;

    @Column(length = 9)
    private String telefono;
}
