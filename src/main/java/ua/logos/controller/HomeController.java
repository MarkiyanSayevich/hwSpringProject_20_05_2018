package ua.logos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes("usersList")
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
	
//	@GetMapping("/users/page")
//	public String showUsersPage(Model model,
//			@PageableDefault Pageable pageable) {
//		
//		Page<User> page = userService.findUsersByPage(pageable);
//		
//		model.addAttribute("userListByPage", page.getContent());
//		
//		return "users";
//	}
	
	@GetMapping("/one")
	public String showOne(@PageableDefault Pageable pageable,
			Model model) {
		
		Page<User> page = userService.findUsersByPage(pageable);
		
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());
		
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("usersList", page);
		model.addAttribute("usersPage", page.getContent());
		
		return "one";
	}
	
	@GetMapping("/one/filter")
	public String showOneFilter(@ModelAttribute("filterModel")SimpleFilter filter,
			@PageableDefault Pageable pageable,
			Model model
			) {
		
		Page<User> page = userService.getUserPageFilter(filter, pageable);
		
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());
		if (filter.getSize().toString() == "") filter.setSize(10);
		
		model.addAttribute("filterModel", new SimpleFilter());
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("usersList", page);
		model.addAttribute("usersPage", page.getContent());
		
		return "one";
	}
	
//	@GetMapping("/one/filter")
//	public String ShowFilterPage(@ModelAttribute("usersList") SimpleFilter filter) {
//		
//		return "one";
//	}
	
	
//	@GetMapping("/users")
//	public String showUsers(Model model) {
//		List<User> users = userService.findAllUser();
////		List<UserDtoForList> usersDtoForList = MappForList(users);
//		
//		model.addAttribute("users", users);
//		model.addAttribute("filterModel", new SimpleFilter());
//		return "users";
//	}
	
//	@GetMapping("/users/filter")
//	public String showFilter(
//			@ModelAttribute("filterModel") SimpleFilter filter ,
//			Model model) {
//		List<User> users = userService.findAllByFilter(filter);
////		List<UserDtoForList> usersDtoForList = MappForList(users);
//		
//		model.addAttribute("users", users);
//		return "users";
//	}
	
	
//	@GetMapping("/users/page")
//	public String showUsersByPage(
//			Model model,
//			@PageableDefault Pageable pageable
//			) {
//		
//		Page<User> page = userService.findUsersByPage(pageable);
//		
//		model.addAttribute("userDtoListModel", page);
//		model.addAttribute("filterModel", new SimpleFilter());
//		return "users";
//	}
	
//	@GetMapping("/users/filter")
//	public String filterUsersByPage(
//			@ModelAttribute("filterModel") SimpleFilter filter,
//			Model model,
//			Pageable pageable
//			) {
//		Page<User> page = userService.findAllByFilter(filter);
//		
//		return "users";
//	}
	
}
