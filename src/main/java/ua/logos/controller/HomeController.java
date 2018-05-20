package ua.logos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.logos.dto.UserDTO;
import ua.logos.dto.UserDtoForList;
import ua.logos.dto.filter.SimpleFilter;
import ua.logos.entity.Make;
import ua.logos.entity.User;
import ua.logos.entity.enums.BodyType;
import ua.logos.entity.enums.FuelType;
import ua.logos.repository.UserRepository;
import ua.logos.service.MakeService;
import ua.logos.service.ModelService;
import ua.logos.service.UserService;

import static ua.logos.mapper.UserMapper.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	
	private MakeService makeService;
	private ModelService modelService;
	private UserService userService;
	
	
	@Autowired
	public HomeController(MakeService makeService, ModelService modelService, UserService userService) {
		this.makeService = makeService;
		this.modelService = modelService;
		this.userService = userService;
	}


	@GetMapping("/")
	private ModelAndView showHome() {
		return new ModelAndView("home");
	}

	@GetMapping("/add/make")
	public String showAddMakeForm(Model model) {
		model.addAttribute("carMake", new Make());
		return "add-make";
	}
	
	@PostMapping("/add/make")
	public String saveMake(
			@ModelAttribute("carMake") Make make
			) {
		
		if(makeService.findMakeByName(make.getName().toLowerCase()) == null) {
			makeService.save(make);
		} else {
			return "redirect:/add/make";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/add/model")
	public String showAddModelForm(Model model) {
		
		model.addAttribute("carModel", new ua.logos.entity.Model());
		model.addAttribute("makeList", makeService.findAll());
		model.addAttribute("fuelList", FuelType.values());
		model.addAttribute("bodyList", BodyType.values());
		
		return "add-model";
	}
	
	@PostMapping("/add/model")
	public String saveModel(@ModelAttribute("carModel") ua.logos.entity.Model model) {
		
		modelService.save(model);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/list")
	public String showAll(Model model) {
		model.addAttribute("allData", makeService.findAll());
		return "list";
		
	}
	
	@GetMapping("/add/user")
	public String showUserAdd(Model model) {
		model.addAttribute("userDTOModel", new UserDTO());
		
		return "user-add";
	}
	
	@PostMapping("/add/user")
	public String saveUserAdd(
			@Valid @ModelAttribute("userDTOModel") UserDTO userDto,
			BindingResult br
			) {
		
		if (br.hasErrors()) {
			return"user-add";
		}
		User user = UserDtoToUser(userDto);
		userService.saveUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/users")
	public String showUsers(Model model) {
		List<User> users = userService.findAllUser();
		List<UserDtoForList> usersDtoForList = MappForList(users);
		
		model.addAttribute("userDtoListModel", usersDtoForList);
		model.addAttribute("filterModel", new SimpleFilter());
		return "users";
	}
	
	@GetMapping("/users/filter")
	public String showFilter(
			@ModelAttribute("filterModel") SimpleFilter filter ,
			Model model) {
		List<User> users = userService.findAllByFilter(filter);
		List<UserDtoForList> usersDtoForList = MappForList(users);
		
		model.addAttribute("userDtoListModel", usersDtoForList);
		return "users";
	}
}
