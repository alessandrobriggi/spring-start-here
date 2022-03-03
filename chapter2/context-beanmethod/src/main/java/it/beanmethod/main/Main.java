package it.beanmethod.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.beanmethod.config.ProjectConfiguration;
import it.beanmethod.model.Parrot;

public class Main {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Parrot parrot1 = context.getBean("parrot1", Parrot.class);
		System.out.println("Parrot: " + parrot1.getName());
		Parrot parrot2 = context.getBean("parrot2", Parrot.class);
		System.out.println("Parrot: " + parrot2.getName());
		Parrot parrot3 = context.getBean("parrot3", Parrot.class);
		System.out.println("Parrot: " + parrot3.getName());
		// Viene preso quello annotato con @Primary:
		Parrot parrot = context.getBean(Parrot.class);
		System.out.println("Parrot: " + parrot.getName());
		context.close();
	}

}
