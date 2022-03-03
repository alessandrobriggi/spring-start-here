package it.beanmethod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.beanmethod.model.Parrot;
import it.beanmethod.model.Person;

@Configuration
public class ProjectConfiguration {

	@Bean
	public Parrot parrot() {
		Parrot parrot = new Parrot();
		parrot.setName("Kiki");
		return parrot;
	}
	
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("Alessandro");
		person.setParrot(parrot());
		return person;
	}
	
}
