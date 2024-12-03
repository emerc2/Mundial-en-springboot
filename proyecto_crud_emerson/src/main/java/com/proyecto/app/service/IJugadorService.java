package com.proyecto.app.service;

import java.util.List;

import com.proyecto.app.entity.Jugador;

public interface IJugadorService {
	
	public List<Jugador> findAll();
	
	public void save(Jugador jugador);
	
	public Jugador findOne(Long id);
	
	public void delete(Long id);

}

