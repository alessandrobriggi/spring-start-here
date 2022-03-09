package it.webscopes.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {

	private String username;
	private boolean loggedIn;
	
	public LoggedUserManagementService() {
		this.username = "";
		this.loggedIn = false;
	}
	
	public LoggedUserManagementService(String username) {
		this.username = username;
		loggedIn = true;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (isValidUsername(username)) {
			this.username = username;
			this.loggedIn = true;
		}
	}

	private boolean isValidUsername(String username) {
		return !(username.equals("") || username == null);
	}
	
	public void logout() {
		this.username = "";
		this.loggedIn = false;
	}
	
}
