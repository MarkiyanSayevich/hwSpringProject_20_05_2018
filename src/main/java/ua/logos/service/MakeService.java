package ua.logos.service;

import java.util.List;

import ua.logos.entity.Make;

public interface MakeService {

	void save(Make make);
	
	Make findById(Integer id);
	
	List<Make> findAll();
	
	Make findMakeByName(String name);
	
}
