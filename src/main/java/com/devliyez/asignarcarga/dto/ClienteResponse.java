package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Cliente;
import lombok.Data;

@Data
public class ClienteResponse {

    private Long id;
    private String nombre;
    private String telefono;

    public ClienteResponse(Cliente cliente) {
        this.nombre = cliente.getNombre();
        this.telefono = cliente.getTelefono();
    }
}
