package it.beanmethod.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.beanmethod.config.ProjectConfiguration;
import it.beanmethod.model.Parrot;
import it.beanmethod.model.Person;

public class Main {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Parrot parrot = context.getBean(Parrot.class);
		Person person = context.getBean(Person.class);
		System.out.println(parrot);
		System.out.println(person);
		context.close();
	}

}
