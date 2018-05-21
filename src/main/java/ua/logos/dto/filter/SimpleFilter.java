package ua.logos.dto.filter;

import lombok.Data;

@Data
public class SimpleFilter {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String login;
	
	private Integer minSalary;
	
	private Integer maxSalary;
}
