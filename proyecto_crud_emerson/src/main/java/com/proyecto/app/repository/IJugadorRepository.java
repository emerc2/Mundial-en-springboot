package com.proyecto.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.app.entity.Jugador;

@Repository
public interface IJugadorRepository extends CrudRepository<Jugador, Long> {

}

