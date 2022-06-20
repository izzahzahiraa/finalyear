package com.example.fyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.fyp.data.OrganizationRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=OrganizationRepository.class)
public class FypApplication {

	@Autowired 
	//private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(FypApplication.class, args);
	}

}
