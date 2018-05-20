package ua.logos.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="car_make")
@Getter @Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"models"})
public class Make extends BaseEntity{
	
	private String name;
	
	@OneToMany(mappedBy = "make")
	private List<Model> models = new ArrayList<>();
}
