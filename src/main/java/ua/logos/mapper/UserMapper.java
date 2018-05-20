package ua.logos.mapper;

import java.util.ArrayList;
import java.util.List;

import ua.logos.dto.UserDTO;
import ua.logos.dto.UserDtoForList;
import ua.logos.entity.User;

public interface UserMapper {

	static User UserDtoToUser(UserDTO userDto) {
		User user = new User();
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setLogin(userDto.getLogin());
		user.setPassword(userDto.getPassword());
		
		return user;
	}
	
	static List<UserDtoForList> MappForList(List<User> users) {
		
		List<UserDtoForList> usersDtoForList = new ArrayList<>();
		
		for(int i = 0; i < users.size();i++) {
			UserDtoForList userForList = new UserDtoForList();
			userForList.setId(users.get(i).getId());
			userForList.setFirstName(users.get(i).getFirstName());
			userForList.setLastName(users.get(i).getLastName());
			userForList.setLogin(users.get(i).getLogin());
			userForList.setEmail(users.get(i).getEmail());
			usersDtoForList.add(userForList);
		}
		
		return usersDtoForList;
	}
}
