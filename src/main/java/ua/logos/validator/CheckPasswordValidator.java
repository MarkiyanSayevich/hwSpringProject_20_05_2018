package ua.logos.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.logos.dto.UserDTO;

@Component
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, UserDTO> {

	@Override
	public boolean isValid(UserDTO value, ConstraintValidatorContext context) {
		
		if(value.getPassword() == "" || value.getPasswordConfirm() == "") {
			return false;
		}
		
		if(value.getPassword().equals(value.getPasswordConfirm())) {
			return true;
		}
		
		return false;
	}
	
	

}
