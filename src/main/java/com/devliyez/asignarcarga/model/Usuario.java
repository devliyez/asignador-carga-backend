package com.devliyez.asignarcarga.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private Date fechaRegistro;

    private Boolean habilitado;
    private String rol;
}
