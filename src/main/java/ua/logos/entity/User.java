package ua.logos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.validator.CheckPassword;

@Entity
@Table(name="user", indexes = @Index(columnList = "first_name,last_name"))
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends BaseEntity{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String login;
	
	private String password;
	
	private Integer salary;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private UserInfo userInfo;
}
