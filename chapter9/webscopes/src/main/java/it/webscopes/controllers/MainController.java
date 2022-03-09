package it.webscopes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.webscopes.model.Credentials;
import it.webscopes.services.LoggedUserManagementService;

@Controller
public class MainController {
	
	private static final String LOGIN_SUCCESSFUL = "You are logged in!";
	
	private LoggedUserManagementService loggedUserManagementService;
	
	@Autowired
	public MainController(LoggedUserManagementService loggedUserManagementService) {
		this.loggedUserManagementService = loggedUserManagementService;
	}

	@GetMapping("/main")
	public String main(Model page) {
		if (!loggedUserManagementService.isLoggedIn())
			return "redirect:/login";
		page.addAttribute("loginMessage", loggedUserManagementService.getUsername() + ", " + LOGIN_SUCCESSFUL);
		return "main.html";
	}
	
	@GetMapping("/logout")
	public String logout(Model page) {
		loggedUserManagementService.logout();
		page.addAttribute("loginMessage", "");
		page.addAttribute("credentials", new Credentials("", ""));
		return "redirect:/login";
	}
	
}
