package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Transportista;
import lombok.Data;

@Data
public class TransportistaResponse {

    private Long id;
    private String nombre;
    private String telefono;
    private Boolean disponible;

    public TransportistaResponse(Transportista transportista) {
        this.id = transportista.getUsuarioId();
        this.nombre = transportista.getNombre();
        this.telefono = transportista.getTelefono();
        this.disponible = transportista.getDisponible();
    }
}
