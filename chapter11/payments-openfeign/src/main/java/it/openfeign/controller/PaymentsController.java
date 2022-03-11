package it.openfeign.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.openfeign.model.Payment;
import it.openfeign.proxy.PaymentsProxy;

@RestController
public class PaymentsController {

	private final PaymentsProxy paymentsProxy;
	
	public PaymentsController(PaymentsProxy paymentsProxy) {
		this.paymentsProxy = paymentsProxy;
	}
	
	@PostMapping("/payment") 
	public Payment createPayment(@RequestBody Payment payment) {
		String requestId = UUID.randomUUID().toString();
		return paymentsProxy.createPayment(requestId, payment);
	}
}