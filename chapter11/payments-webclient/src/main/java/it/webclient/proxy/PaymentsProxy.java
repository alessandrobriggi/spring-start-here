package it.webclient.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import it.webclient.model.Payment;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {

	private final WebClient webClient;
	
	@Value("http://localhost:8080")
	private String paymentsServiceUrl;
	
	public PaymentsProxy(WebClient webClient) {
		this.webClient = webClient;
	}
	
	public Mono<Payment> createPayment(String requestId, Payment payment) {
		String uri = paymentsServiceUrl + "/payment";
		return webClient.post()
				.uri(uri)
				.header("requestId", requestId)
				.body(Mono.just(payment), Payment.class)
				.retrieve()
				.bodyToMono(Payment.class);
	}
	
}
