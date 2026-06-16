package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
}
