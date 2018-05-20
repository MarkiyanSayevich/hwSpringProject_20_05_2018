package ua.logos.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import ua.logos.validator.CheckIfUserExists;

@Data
public class UserDTO {

	@NotEmpty(message = " - First Name cannot be empty - ")
	private String firstName;
	
	@NotEmpty(message = " - Last Name cannot be empty - ")
	private String lastName;
	
	@NotEmpty(message= " - Email cannot be empty -")
	private String email;
	
	@CheckIfUserExists(message = " - User is already exists - ")
	@NotEmpty(message= " - Login cannot be empty -")
	private String login;
	
	@NotEmpty(message= " - Password cannot be empty - ")
	private String password;
	
	@NotEmpty(message=" - Confirm password area cannot be empty - ")
	private String passwordConfirm;
}
