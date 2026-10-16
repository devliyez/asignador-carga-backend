package com.devliyez.backend.dto.TransportistaDTO;

import com.devliyez.backend.model.Transportista;
import lombok.Data;

@Data
public class TransportistaResponse {

    private Long id;
    private String nombre;
    private Boolean disponible;

    public TransportistaResponse(Transportista transportista) {
        this.id = transportista.getId();
        this.nombre = transportista.getNombre();
        this.disponible = transportista.getDisponible();
    }
}
