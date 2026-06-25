package com.devliyez.asignarcarga.services.Cliente;

import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRegistrar;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRequest;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse>getClientes();
    ClienteResponse getClienteById(Long id);
    ClienteResponse postCliente(ClienteRegistrar dto);
    ClienteResponse updateCliente(ClienteRequest cliente, Long id);
    void deleteCliente(Long id);

}
