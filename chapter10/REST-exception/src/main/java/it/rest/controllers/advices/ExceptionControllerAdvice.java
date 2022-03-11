package it.rest.controllers.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import it.rest.exceptions.NotEnoughMoneyException;
import it.rest.models.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(NotEnoughMoneyException.class)
	public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage("Not enough Money!!!");
		return ResponseEntity
				.badRequest()
				.body(errorDetails);
	}

}
