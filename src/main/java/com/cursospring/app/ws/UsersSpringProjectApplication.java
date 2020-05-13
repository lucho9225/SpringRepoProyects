package com.cursospring.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages= {"com.cursospring.app.ws","com.cursospring.app.ws.users"})
public class UsersSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersSpringProjectApplication.class, args);
	}

}
