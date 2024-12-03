package com.proyecto.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.app.entity.Club;
import com.proyecto.app.repository.IClubRepository;

import java.util.List;

@Service
public class ClubService implements IClubService {

    @Autowired
    private IClubRepository clubRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Club> findAll() {
        return (List<Club>) clubRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Club club) {
        clubRepository.save(club);
    }

    @Override
    @Transactional(readOnly = true)
    public Club findOne(Long id) {
        return clubRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }
}

