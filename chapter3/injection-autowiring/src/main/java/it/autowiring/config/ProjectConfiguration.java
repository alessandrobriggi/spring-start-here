package it.autowiring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import it.autowiring.model.Parrot;

@Configuration
@ComponentScan(basePackages = { "it.autowiring.model" })
public class ProjectConfiguration {
	
	@Bean
	public Parrot parrot() {
		Parrot parrot = new Parrot();
		parrot.setName("Kiki");
		return parrot;
	}

}
