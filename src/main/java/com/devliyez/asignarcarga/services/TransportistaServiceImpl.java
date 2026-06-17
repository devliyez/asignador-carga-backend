package com.devliyez.asignarcarga.services;

import com.devliyez.asignarcarga.dto.transportistaRegistrar;
import com.devliyez.asignarcarga.model.Transportista;
import com.devliyez.asignarcarga.model.Usuario;
import com.devliyez.asignarcarga.repository.TransportistaRepository;
import com.devliyez.asignarcarga.repository.UsuarioRepository;
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
    public List<Transportista> getTransportistas(){
        return transportistaRepository.findAll();
    }

    @Override
    public Optional<Transportista> getTransportistaById(Long id) {
        return transportistaRepository.findById(id);
    }

    @Override
    public Transportista postTransportista(transportistaRegistrar dto ) {

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



        return transportistaRepository.save(transportista);
    }

    @Override
    public Transportista updateTransportista(Transportista transportista, Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Transportista no encontrado"));

        t.setNombre(transportista.getNombre());
        t.setTelefono(transportista.getTelefono());
        t.setDisponible(transportista.getDisponible());
        t.setUsuario(transportista.getUsuario());

        transportistaRepository.save(t);

        return t;
    }

    @Override
    public void deleteTransportista(Long id) {

        Transportista t = transportistaRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));

        usuario.setHabilitado(false);
        usuarioRepository.save(usuario);



    }


}
