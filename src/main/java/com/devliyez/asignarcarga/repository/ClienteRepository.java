package com.devliyez.asignarcarga.repository;

import com.devliyez.asignarcarga.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
