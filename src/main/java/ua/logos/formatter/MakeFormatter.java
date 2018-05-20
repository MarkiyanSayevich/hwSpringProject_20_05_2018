package ua.logos.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import ua.logos.entity.Make;

@Component
public class MakeFormatter implements Formatter<Make>{


	@Override
	public String print(Make object, Locale locale) {
		System.out.println("Print: " + object.getId() + ", "+ object.getName());
		return String.valueOf(object.getId() + ", " + object.getName());
	}

	@Override
	public Make parse(String idStr, Locale locale) throws ParseException {
		System.out.println("Parse: " + idStr);
		
		idStr.split(", ");
		int makeId = Integer.valueOf(idStr.split(", ")[0]);
		//int makeId = Integer.valueOf(idStr);
		
		Make make = new Make();
		make.setId(makeId);
		return make;
	}
}
