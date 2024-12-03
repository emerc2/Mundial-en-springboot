package com.proyecto.app.service;

import java.util.List;

import com.proyecto.app.entity.Club;

public interface IClubService {
	
	public List<Club> findAll();
	
	public void save(Club club);
	
	public Club findOne(Long id);
	
	public void delete(Long id);

}
