package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.clienteRegistrar;
import com.devliyez.asignarcarga.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente>getClientes();
    Optional<Cliente> getClienteById(Long id);
    Cliente postCliente(clienteRegistrar dto);
    Cliente updateCliente(Cliente cliente, Long id);
    void deleteCliente(Long id);

}
