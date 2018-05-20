package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.Model;
import ua.logos.repository.ModelRepository;
import ua.logos.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{

	@Autowired private ModelRepository modelRepos;

	@Override
	public void save(Model model) {
		modelRepos.save(model);
	}

	@Override
	public Model findById(Integer id) {
		return modelRepos.getOne(id);
	}

	@Override
	public List<Model> findAll() {
		return modelRepos.findAll();
	}
	
	
}
