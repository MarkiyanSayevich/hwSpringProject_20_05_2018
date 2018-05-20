package ua.logos.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.logos.entity.enums.BodyType;
import ua.logos.entity.enums.FuelType;

@Entity
@Table(name="car_model")
@Getter @Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Model extends BaseEntity{
	
	private String name;
	
	private String year;
	
	@ManyToOne
	@JoinColumn(name="make_id")
	private Make make;
	
	
	@Enumerated(EnumType.STRING)
	private FuelType fuelType;
	
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
}
