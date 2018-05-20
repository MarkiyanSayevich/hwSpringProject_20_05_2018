package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.validator.CheckPassword;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@CheckPassword(message = "Check password confirm")
public class User extends BaseEntity{

	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String login;
	
	private String password;
}
