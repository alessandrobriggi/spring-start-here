package it.resttemplate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.resttemplate.model.Payment;
import it.resttemplate.proxy.PaymentsProxy;

@RestController
public class PaymentsController {

	private final PaymentsProxy paymentsProxy;
	
	public PaymentsController(PaymentsProxy paymentsProxy) {
		this.paymentsProxy = paymentsProxy;
	}
	
	@PostMapping("/payment") 
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentsProxy.createPayment(payment);
	}
}
