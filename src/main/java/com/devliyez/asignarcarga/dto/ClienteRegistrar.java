package com.devliyez.asignarcarga.dto;

import lombok.Data;

@Data
public class ClienteRegistrar {

    private String email;
    private String password;
    private String rol;

    private String nombre;
    private String telefono;
}
