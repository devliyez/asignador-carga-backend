package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Cliente;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class clienteResponse {

    private String nombre;
    private String telefono;

    public clienteResponse(Cliente cliente) {
        this.nombre = cliente.getNombre();
        this.telefono = cliente.getTelefono();
    }
}
