package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.TransportistaRegistrar;
import com.devliyez.asignarcarga.dto.TransportistaRequest;
import com.devliyez.asignarcarga.dto.TransportistaResponse;
import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Usuario;
import com.devliyez.asignarcarga.repository.TransportistaRepository;
import com.devliyez.asignarcarga.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransportistaServiceImpl implements TransportistaService{

    private final TransportistaRepository transportistaRepository;

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<TransportistaResponse> getTransportistas(){
        return transportistaRepository.findAll()
                .stream()
                .map(TransportistaResponse::new)
                .toList();
    }

    @Override
    public TransportistaResponse getTransportistaById(Long id) {

        Transportista t = transportistaRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Transportista no encontrado"));

        return new TransportistaResponse(t);
    }

    @Override
    public TransportistaResponse postTransportista(TransportistaRegistrar dto ) {

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

        return new TransportistaResponse(transportistaRepository.save(transportista));
    }

    @Override
    public TransportistaResponse updateTransportista(TransportistaRequest transportista, Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportista no encontrado"));

        t.setNombre(transportista.getNombre());
        t.setTelefono(transportista.getTelefono());
        t.setDisponible(transportista.getDisponible());

        transportistaRepository.save(t);

        return new TransportistaResponse(t);
    }

    @Override
    public void deleteTransportista(Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        usuario.setHabilitado(false);
        usuarioRepository.save(usuario);



    }


}
