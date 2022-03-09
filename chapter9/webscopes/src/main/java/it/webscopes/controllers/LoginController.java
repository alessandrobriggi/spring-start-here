package it.webscopes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.webscopes.model.Credentials;
import it.webscopes.services.LoggedUserManagementService;
import it.webscopes.services.LoginService;

@Controller
public class LoginController {
	
	private static final String LOGIN_UNSUCCESSFUL = "Wrong username or password!";

	private LoginService loginService;
	private LoggedUserManagementService loggedUserManagementService;
	
	public LoginController(LoginService loginService, LoggedUserManagementService loggedUserManagementService) {
		this.loginService = loginService;
		this.loggedUserManagementService = loggedUserManagementService;
	}
	
	@ModelAttribute(name = "loginMessage")
	public String loginMessage() {
		return "";
	}
	
	@ModelAttribute(name = "credentials")
	public Credentials credentials() {
		return new Credentials("", "");
	}
	
	@GetMapping("/login")
	public String home() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String authenticate(Credentials credentials, Model page) {
		loginService.setCredentials(credentials);
		if (loginService.loginIsSuccessful()) {
			loggedUserManagementService.setUsername(credentials.getUsername());
			return "redirect:/main";
		}
		else {
			page.addAttribute("loginMessage", LOGIN_UNSUCCESSFUL);
			page.addAttribute("credentials", new Credentials("", ""));
			return "login.html";
		}
	}
	
}
