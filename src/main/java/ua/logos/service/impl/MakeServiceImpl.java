package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.logos.entity.Make;
import ua.logos.repository.MakeRepository;
import ua.logos.service.MakeService;

@Repository
public class MakeServiceImpl implements MakeService{

	@Autowired private MakeRepository makeRepos;
	
	@Override
	public void save(Make make) {
		makeRepos.save(make);
	}

	@Override
	public Make findById(Integer id) {
		return makeRepos.getOne(id);
	}

	@Override
	public List<Make> findAll() {
		return makeRepos.findAll();
	}

	@Override
	public Make findMakeByName(String name) {
		return makeRepos.findMakeByName(name);
	}
}
