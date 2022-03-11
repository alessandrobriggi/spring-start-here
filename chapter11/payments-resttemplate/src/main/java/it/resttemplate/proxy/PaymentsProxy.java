package it.resttemplate.proxy;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.resttemplate.model.Payment;

@Component
public class PaymentsProxy {

	private final RestTemplate rest;
	
	@Value("http://localhost:8080")
	private String paymentsServiceUrl;
	
	public PaymentsProxy(RestTemplate restTemplate) {
		this.rest = restTemplate;
	}
	
	public Payment createPayment(Payment payment) {
		String uri = paymentsServiceUrl + "/payment";
		HttpHeaders headers = new HttpHeaders();
		headers.add("requestId", UUID.randomUUID().toString());
		HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
		ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);
		return response.getBody();
	}
	
}
