package it.rest.services;

import org.springframework.stereotype.Service;

import it.rest.exceptions.NotEnoughMoneyException;
import it.rest.models.PaymentDetails;

@Service
public class PaymentService {
	
	public PaymentDetails processPayment() {
		throw new NotEnoughMoneyException();
	}

}
