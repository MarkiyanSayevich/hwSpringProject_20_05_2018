package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_info")
@Getter
@Setter
@NoArgsConstructor
public class UserInfo extends BaseEntity {

	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name= "file_name")
	private String fileName;
	
}
