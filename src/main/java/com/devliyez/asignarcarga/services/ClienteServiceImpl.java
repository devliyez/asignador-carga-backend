package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.clienteRegistrar;
import com.devliyez.asignarcarga.dto.clienteRequest;
import com.devliyez.asignarcarga.dto.clienteResponse;
import com.devliyez.asignarcarga.model.Cliente;
import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Usuario;
import com.devliyez.asignarcarga.repository.ClienteRepository;
import com.devliyez.asignarcarga.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<clienteResponse> getClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteResponse :: new)
                .toList();
    }

    @Override
    public clienteResponse getClienteById(Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cliente no encontrado"));
        return new clienteResponse(c);
    }

    @Override
    public clienteResponse postCliente(clienteRegistrar dto) {

        Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol("CLIENTE");
        usuario.setHabilitado(true);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setUsuario(usuarioGuardado);

        clienteRepository.save(cliente);

        return new clienteResponse(cliente);
    }

    @Override
    public clienteResponse updateCliente(clienteRequest cliente, Long id) {

        Cliente c = clienteRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        c.setNombre(cliente.getNombre());
        c.setTelefono(cliente.getTelefono());

        clienteRepository.save(c);

        return new clienteResponse(c);
    }

    @Override
    public void deleteCliente(Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        usuario.setHabilitado(false);

        usuarioRepository.save(usuario);

    }



}