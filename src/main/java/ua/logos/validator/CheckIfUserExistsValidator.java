package ua.logos.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.logos.repository.UserRepository;

public class CheckIfUserExistsValidator implements ConstraintValidator<CheckIfUserExists, String> {
	
	@Autowired UserRepository userRepos; 
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(userRepos.findUserByLogin(value.toLowerCase()) == null) {
			return true;
		}
		return false;
	}
	
	

}
