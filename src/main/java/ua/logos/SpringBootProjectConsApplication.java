package ua.logos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import ua.logos.entity.User;
import ua.logos.repository.UserRepository;

@SpringBootApplication
public class SpringBootProjectConsApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootProjectConsApplication.class);
	}

	public static void main(String[] args) throws IOException {
		 ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootProjectConsApplication.class, args);
		 addUsers(ctx);
	}
	
	private static void addUsers(ConfigurableApplicationContext ctx) throws IOException {
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		Long users = userRepository.count();
		FileReader frfn = null;
		FileReader frln = null;
        BufferedReader brfn = null;
        BufferedReader brln = null;
        String line = null;
        int firstCount = 0;
        int lastCount = 0;
        List<String> firstNames = null;
        List<String> lastNames = null;
		
        File firstNameFile = new File("firstName.txt");
        File lastNameFile = new File("lastName.txt");
        
        System.out.println("Users in DB: " + users);
        
		if(users == 0) {
			
			try {
				frfn = new FileReader(firstNameFile);
				frln = new FileReader(lastNameFile);
				brfn = new BufferedReader(frfn);
				brln = new BufferedReader(frln);
				
				firstNames = new ArrayList<>();
				lastNames = new ArrayList<>();
				
				while((line = brfn.readLine()) != null) {
					firstCount += 1; 
					firstNames.add(line);
				}
				
				while((line = brln.readLine()) != null ) {
					lastCount += 1;
					lastNames.add(line);
				}
				System.out.println("First names: " + firstCount); 
				System.out.println("Array with names = " + firstNames.size());
				System.out.println("Last names: " + lastCount);
				System.out.println("Arrays with lasts: "  + lastNames.size());
				
				for(int i = 0; i< 2000; i++) {
					User user = new User();
					user.setFirstName(firstNames.get(new Random().nextInt(firstCount - 1) + 1));
					user.setLastName(lastNames.get(new Random().nextInt(lastCount - 1) + 1));
					user.setEmail(user.getFirstName() + user.getLastName() + "@gmail.com");
					user.setLogin(user.getFirstName() + user.getLastName() + Integer.toString(new Random().nextInt(100000)));
					user.setPassword(Integer.toString(new Random().nextInt(1000))+ user.getLastName() + user.getFirstName() + Integer.toString(new Random().nextInt(1000)));
					userRepository.save(user);
				}
				
			} catch (FileNotFoundException fnfe) {
				System.err.println("File: " + firstNameFile + " not found.");
				return;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				frfn.close();
				frln.close();
				brfn.close();
				brln.close();
			}
		}
	}
}
