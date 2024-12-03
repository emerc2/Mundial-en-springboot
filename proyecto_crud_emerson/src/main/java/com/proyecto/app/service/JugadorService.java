package com.proyecto.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.entity.Jugador;
import com.proyecto.app.repository.IJugadorRepository;

import java.util.List;

@Service
public class JugadorService implements IJugadorService {

    @Autowired
    private IJugadorRepository jugadorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Jugador> findAll() {
        return (List<Jugador>) jugadorRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

    @Override
    @Transactional(readOnly = true)
    public Jugador findOne(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }
}

