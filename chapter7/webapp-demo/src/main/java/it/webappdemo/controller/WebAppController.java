package it.webappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAppController {

	@GetMapping("/home")
	public String home() {
		return "home.html";
	}
	
}
