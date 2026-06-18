package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.clienteRegistrar;
import com.devliyez.asignarcarga.dto.clienteRequest;
import com.devliyez.asignarcarga.dto.clienteResponse;
import com.devliyez.asignarcarga.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<clienteResponse>getClientes();
    clienteResponse getClienteById(Long id);
    clienteResponse postCliente(clienteRegistrar dto);
    clienteResponse updateCliente(clienteRequest cliente, Long id);
    void deleteCliente(Long id);

}
