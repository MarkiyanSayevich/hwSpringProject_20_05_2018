package ua.logos.service;

import java.util.List;

import ua.logos.dto.UserDtoForList;
import ua.logos.dto.filter.SimpleFilter;
import ua.logos.entity.User;

public interface UserService {

	void saveUser(User user);
	
	User getUserById(Integer id);
	
	List<User> findAllUser();
	
	List<User> findAllByFilter(SimpleFilter filter);
}
