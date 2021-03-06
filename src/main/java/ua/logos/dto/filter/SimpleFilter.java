package ua.logos.dto.filter;

import lombok.Data;

@Data
public class SimpleFilter {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String login;
	
	private String minSalary;
	
	private String maxSalary;
	
	private Integer size;
}
