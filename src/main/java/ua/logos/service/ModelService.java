package ua.logos.service;

import java.util.List;

import ua.logos.entity.Model;

public interface ModelService {

	void save(Model model);
	
	Model findById(Integer id);
	
	List<Model> findAll();
}
