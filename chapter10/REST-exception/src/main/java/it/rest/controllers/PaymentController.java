package it.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rest.models.PaymentDetails;
import it.rest.services.PaymentService;

@RestController
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/makePayment")
	public ResponseEntity<?> makePayment() {
		PaymentDetails paymentDetails = paymentService.processPayment();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
	}

}
