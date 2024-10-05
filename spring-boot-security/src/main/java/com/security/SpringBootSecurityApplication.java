package com.security;

import com.security.models.User;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String passUser1=passwordEncoder.encode("abc");
		String passUser2=passwordEncoder.encode("abcxyz");

		User user1=new User("vishal",passUser1,"abc@gmail.com","ROLE_NORMAL");
		User user2=new User("vinay",passUser2,"xyz@gmail.com","ROLE_ADMIN");
		this.userRepo.save(user1);
		this.userRepo.save(user2);

	}
}
