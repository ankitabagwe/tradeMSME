package com.example.tradeMSME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan(basePackages = {"testcontroller", "service", "repository"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")

public class tradeMSMEApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(tradeMSMEApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(tradeMSMEApplication.class);
	}
}
