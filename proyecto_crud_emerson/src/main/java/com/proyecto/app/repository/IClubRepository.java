package com.proyecto.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.app.entity.Club;

@Repository
public interface IClubRepository extends CrudRepository<Club, Long> {

}

