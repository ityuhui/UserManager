package com.yuhuixa.usermanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yuhuixa.usermanager.user.User;
import com.yuhuixa.usermanager.user.UserRepository;

@SpringBootApplication
public class UsermanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermanagerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			User maria = new User("Maria", "maria@gmail.com");
			userRepository.save(maria);
		};
	}

}
