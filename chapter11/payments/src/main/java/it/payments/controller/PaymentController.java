package it.payments.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import it.payments.model.Payment;

@RestController
public class PaymentController {

	private static Logger logger = Logger.getLogger(PaymentController.class.getName());
	
	@PostMapping("/payment")
	public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
		logger.info("Received request with ID " + requestId + " ; Payment amount: " + payment.getAmount());
		payment.setId(requestId);
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("requestId", requestId)
				.body(payment);
	}
	
}
