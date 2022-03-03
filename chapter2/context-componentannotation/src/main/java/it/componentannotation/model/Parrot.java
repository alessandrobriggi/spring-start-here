package it.componentannotation.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

	private String name;
	
	@PostConstruct
	public void init() {
		setName("Kiki");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
