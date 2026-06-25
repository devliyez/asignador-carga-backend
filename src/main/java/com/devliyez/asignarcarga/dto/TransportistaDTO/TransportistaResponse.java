package com.devliyez.asignarcarga.dto.TransportistaDTO;

import com.devliyez.asignarcarga.model.Transportista;
import lombok.Data;

@Data
public class TransportistaResponse {

    private Long id;
    private String nombre;
    private String telefono;
    private Boolean disponible;
    private String rol;

    public TransportistaResponse(Transportista transportista) {
        this.id = transportista.getUsuarioId();
        this.nombre = transportista.getNombre();
        this.telefono = transportista.getTelefono();
        this.disponible = transportista.getDisponible();
        this.rol = transportista.getUsuario().getRol();
    }
}
