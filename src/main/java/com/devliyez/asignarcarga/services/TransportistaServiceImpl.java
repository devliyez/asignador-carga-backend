package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.transportistaRegistrar;
import com.devliyez.asignarcarga.dto.transportistaRequest;
import com.devliyez.asignarcarga.dto.transportistaResponse;
import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Usuario;
import com.devliyez.asignarcarga.repository.TransportistaRepository;
import com.devliyez.asignarcarga.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TransportistaServiceImpl implements TransportistaService{

    private final TransportistaRepository transportistaRepository;

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<transportistaResponse> getTransportistas(){
        return transportistaRepository.findAll()
                .stream()
                .map(transportistaResponse ::new)
                .toList();
    }

    @Override
    public transportistaResponse getTransportistaById(Long id) {

        Transportista t = transportistaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Transportista no encontrado"));

        return new transportistaResponse(t);
    }

    @Override
    public transportistaResponse postTransportista(transportistaRegistrar dto ) {

        Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol("TRANSPORTISTA");
        usuario.setHabilitado(true);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Transportista transportista = new Transportista();
        transportista.setNombre(dto.getNombre());
        transportista.setTelefono(dto.getTelefono());
        transportista.setDisponible(true);
        transportista.setUsuario(usuarioGuardado);

        return new transportistaResponse(transportistaRepository.save(transportista));
    }

    @Override
    public transportistaResponse updateTransportista(transportistaRequest transportista, Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportista no encontrado"));

        t.setNombre(transportista.getNombre());
        t.setTelefono(transportista.getTelefono());
        t.setDisponible(transportista.getDisponible());

        transportistaRepository.save(t);

        return new transportistaResponse(t);
    }

    @Override
    public void deleteTransportista(Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        usuario.setHabilitado(false);
        usuarioRepository.save(usuario);



    }


}
