package com.qwerty.socialmediarestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SocialMediaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaRestApiApplication.class, args);
	}

}
