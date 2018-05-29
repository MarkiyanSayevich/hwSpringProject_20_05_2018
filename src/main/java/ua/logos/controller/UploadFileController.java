package ua.logos.controller;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.logos.entity.UploadFile;
import ua.logos.service.UploadFileService;
import ua.logos.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/upload")
public class UploadFileController {

	@Autowired UploadFileService uploadFileService;
	
	@GetMapping("/db")
	public String showUploadToDb(Model model) {
		
		model.addAttribute("uploadFileModel", new UploadFile());
		
		return "upload-db";
	}
	
	@PostMapping("/db")
	public String saveUploadedFile(
			@ModelAttribute UploadFile file) throws IOException {
		
		file.setFileName(file.getFile().getOriginalFilename());
		file.setFileData(file.getFile().getBytes());
		
		uploadFileService.save(file);
		
		return "redirect:/";
	}
	
//	@PostMapping("/db")
//	public String saveUploadedFile(
//			@RequestParam("uploadFile") MultipartFile multipatFile) throws IOException {
//		
//		System.out.println("File Name: " + multipatFile.getOriginalFilename());
//		
//		UploadFile file = new UploadFile();
//		
//		file.setFileName(multipatFile.getOriginalFilename());
//		file.setFileData(multipatFile.getBytes());
//		
//		uploadFileService.save(file);
//		
//		return "redirect:/";
//	}
	
	@GetMapping("/show")
	public String showFromDb(Model model) throws IOException {
		
		String encodeFile = CustomFileUtils.getImage("/user_1", "1.jpg");
		
		model.addAttribute("imgSrc", encodeFile);

		return "show";
	}
	
	@GetMapping("/fs")
	public String showUploadImage() {
		return "upload-fs";
	}
	
	@PostMapping("/fs")
	public String saveToFs(@RequestParam("fileImage") MultipartFile file) throws IOException {
		
		System.out.println(file.getOriginalFilename());
		CustomFileUtils.createImage("test", file);
		
		return "redirect:/";
	}
}
