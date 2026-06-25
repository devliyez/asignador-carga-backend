package com.devliyez.asignarcarga.dto.ClienteDTO;

import com.devliyez.asignarcarga.model.Cliente;
import lombok.Data;

@Data
public class ClienteResponse {

    private Long id;
    private String nombre;
    private String telefono;
    private String rol;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getUsuarioId();
        this.nombre = cliente.getNombre();
        this.telefono = cliente.getTelefono();
        this.rol = cliente.getUsuario().getRol();
    }
}
