package com.krakdev.apihibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.krakdev.apihibernate", "com.krakdev.peliculas"})
@EntityScan(basePackages = "com.krakdev.peliculas.entidades")
@EnableJpaRepositories(basePackages = "com.krakdev.peliculas.repository")
public class ApihibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApihibernateApplication.class, args);
	}
}
