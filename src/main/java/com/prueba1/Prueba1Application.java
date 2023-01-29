package com.prueba1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.prueba1.entity"})
public class Prueba1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1Application.class, args);
	}
	
	
}
