package it.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rest.model.Country;

@RestController
public class CountryController {

	@GetMapping("/italia")
	public ResponseEntity<Country> italia() {
		Country italia = Country.of("Italia", 65);
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.header("continente", "Europa")
				.header("capitale", "Roma")
				.header("cibo_preferito", "Pizza")
				.body(italia);
	}
	
	@GetMapping("/all") 
	public List<Country> getAll() {
		Country italy = Country.of("Italia", 65);
		Country spain = Country.of("Spagna", 50);
		return List.of(italy, spain);
	}
	
}
