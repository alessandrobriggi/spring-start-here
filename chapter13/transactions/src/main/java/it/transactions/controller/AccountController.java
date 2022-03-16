package it.transactions.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.transactions.dto.TransferRequest;
import it.transactions.model.Account;
import it.transactions.service.AccountService;

@RestController
public class AccountController {

	private final AccountService service;
	
	public AccountController(AccountService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public List<Account> findAll() {
		return service.findAll();
	}
	
	@PostMapping("/transfer")
	public void transfer(@RequestBody TransferRequest request) {
		long idSender = request.getIdSender();
		long idReceiver = request.getIdReceiver();
		BigDecimal amount = request.getAmount();
		service.transferMoney(idSender, idReceiver, amount);
	}
	
}
