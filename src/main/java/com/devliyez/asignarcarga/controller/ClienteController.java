package com.devliyez.asignarcarga.controller;

import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRegistrar;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRequest;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteResponse;
import com.devliyez.asignarcarga.services.Cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public ClienteResponse getClienteById(@PathVariable Long id){
        return clienteService.getClienteById(id);
    }

    @PostMapping("/crear")
    public ClienteResponse postCliente(@RequestBody ClienteRegistrar c){

        return clienteService.postCliente(c);
    }

    @PutMapping("/actualizar/{id}")
    public ClienteResponse updateCliente(@RequestBody ClienteRequest c, @PathVariable Long id){
        return clienteService.updateCliente(c,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
    }
}
