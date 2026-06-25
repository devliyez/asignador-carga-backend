package com.devliyez.asignarcarga.services.Cliente;

import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRegistrar;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteRequest;
import com.devliyez.asignarcarga.dto.ClienteDTO.ClienteResponse;
import com.devliyez.asignarcarga.model.Cliente;
import com.devliyez.asignarcarga.model.Usuario;
import com.devliyez.asignarcarga.repository.ClienteRepository;
import com.devliyez.asignarcarga.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<ClienteResponse> getClientes() {
        return clienteRepository.findAll()
                .stream()
                .filter(c -> c.getUsuario().getHabilitado().equals(true))
                .map(ClienteResponse:: new)
                .toList();
    }

    @Override
    public ClienteResponse getClienteById(Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cliente no encontrado"));
        return new ClienteResponse(c);
    }

    @Override
    public ClienteResponse postCliente(ClienteRegistrar dto) {

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

        return new ClienteResponse(cliente);
    }

    @Override
    public ClienteResponse updateCliente(ClienteRequest cliente, Long id) {

        Cliente c = clienteRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        c.setNombre(cliente.getNombre());
        c.setTelefono(cliente.getTelefono());

        clienteRepository.save(c);

        return new ClienteResponse(c);
    }

    @Override
    public void deleteCliente(Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        usuario.setHabilitado(false);

        usuarioRepository.save(usuario);

    }



}