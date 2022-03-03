package it.parameterinbeanmethod.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import it.parameterinbeanmethod.model.Parrot;
import it.parameterinbeanmethod.model.Person;

@Configuration
public class ProjectConfiguration {

	@Bean
	public Parrot parrot1() {
		Parrot parrot = new Parrot();
		parrot.setName("Kiki");
		return parrot;
	}
	
	@Bean
	public Parrot parrot2() {
		Parrot parrot = new Parrot();
		parrot.setName("Miki");
		return parrot;
	}
	
	@Bean
	@Primary
	public Parrot parrot3() {
		Parrot parrot = new Parrot();
		parrot.setName("Koko");
		return parrot;
	}
	
	@Bean
	public Person person(@Qualifier("parrot1") Parrot parrot) {
		Person person = new Person();
		person.setName("Alessandro");
		person.setParrot(parrot);
		return person;
	}
	
}
