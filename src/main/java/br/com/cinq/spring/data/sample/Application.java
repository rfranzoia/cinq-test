package br.com.cinq.spring.data.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main application to run boot application.
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.com.cinq.spring.data.sample"})
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}