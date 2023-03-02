package com.library.library;

import com.library.library.user.User;
import com.library.library.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setEmail("email@email.com");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPassword("password");
		user.setEnabled(Boolean.valueOf("True"));

		userRepository.save(user);
	}

}
