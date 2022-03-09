package it.webscopes.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import it.webscopes.model.Credentials;

@Service
@RequestScope
public class LoginService {

	private static final String USERNAME_ACCEPTED = "Alessandro";
	private static final String PASSWORD_ACCEPTED = "password";

	private Credentials credentials;
	
	public LoginService() {
	}

	public LoginService(Credentials credentials) {
		this.credentials = credentials;
	}

	public boolean loginIsSuccessful() {
		if (credentialsAreCorrect(credentials))
			return true;
		else
			return false;
	}

	private boolean credentialsAreCorrect(Credentials credentials) {
		Credentials validCredentials = new Credentials(USERNAME_ACCEPTED, PASSWORD_ACCEPTED);
		return validCredentials.equals(credentials);
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
