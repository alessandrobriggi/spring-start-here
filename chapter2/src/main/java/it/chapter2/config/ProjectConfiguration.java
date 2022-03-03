package it.chapter2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import it.chapter2.model.Parrot;

@Configuration
public class ProjectConfiguration {
	
	@Bean
	public Parrot parrot1() {
		Parrot parrot = new Parrot();
		parrot.setName("Kiki");
		return parrot;
	}
	
	@Bean
	@Primary
	public Parrot parrot2() {
		Parrot parrot = new Parrot();
		parrot.setName("Miki");
		return parrot;
	}
	
	@Bean
	public Parrot parrot3() {
		Parrot parrot = new Parrot();
		parrot.setName("Koko");
		return parrot;
	}

}
