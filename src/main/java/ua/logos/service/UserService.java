package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.logos.dto.filter.SimpleFilter;
import ua.logos.entity.User;

public interface UserService {

	void saveUser(User user);
	
	User getUserById(Integer id);
	
	List<User> findAllUser();
	
	List<User> findAllByFilter(SimpleFilter filter);
	
	Page<User> findUsersByPage(Pageable pageable);
	
	Page<User> getUserPageFilter(SimpleFilter filter , Pageable pageable);
}