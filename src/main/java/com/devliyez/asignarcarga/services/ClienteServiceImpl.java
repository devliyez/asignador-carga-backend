package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.clienteRegistrar;
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
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cliente no encontrado"));



        return clienteRepository.findById(id);
    }

    @Override
    public Cliente postCliente(clienteRegistrar dto) {

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


        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente, Long id) {

        Cliente c = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));

        c.setNombre(cliente.getNombre());
        c.setTelefono(cliente.getTelefono());
        c.setUsuario(cliente.getUsuario());

        return clienteRepository.save(c);
    }

    @Override
    public void deleteCliente(Long id) {


    }



}