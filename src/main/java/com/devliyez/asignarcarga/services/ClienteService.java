package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.ClienteRegistrar;
import com.devliyez.asignarcarga.dto.ClienteRequest;
import com.devliyez.asignarcarga.dto.ClienteResponse;

import java.util.List;

public interface ClienteService {

    List<ClienteResponse>getClientes();
    ClienteResponse getClienteById(Long id);
    ClienteResponse postCliente(ClienteRegistrar dto);
    ClienteResponse updateCliente(ClienteRequest cliente, Long id);
    void deleteCliente(Long id);

}
