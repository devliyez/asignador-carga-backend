package com.devliyez.asignarcarga.dto;

import com.devliyez.asignarcarga.model.Transportista;
import lombok.Data;

@Data
public class transportistaResponse {

    private String nombre;
    private String telefono;
    private Boolean disponible;

    public transportistaResponse(Transportista transportista) {
        this.nombre = transportista.getNombre();
        this.telefono = transportista.getTelefono();
        this.disponible = transportista.getDisponible();
    }
}
