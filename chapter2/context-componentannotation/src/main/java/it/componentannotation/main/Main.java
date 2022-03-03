package it.componentannotation.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.componentannotation.config.ProjectConfiguration;
import it.componentannotation.model.Parrot;

public class Main {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		Parrot parrot1 = context.getBean(Parrot.class);
		System.out.println("Parrot: " + parrot1.getName());
		context.close();
	}

}
