package ua.logos.dto;

import lombok.Data;

@Data
public class UserDtoForList {

	private Integer id;
	
	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private String login;
}

