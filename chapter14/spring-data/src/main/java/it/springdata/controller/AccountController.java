package it.springdata.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.springdata.dao.Account;
import it.springdata.dto.TransferRequest;
import it.springdata.service.AccountService;

@RestController
public class AccountController {
	
	private final AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/find")
	public Iterable<Account> find(@RequestParam(required = false) String name) {
		if (name == null) 
			return accountService.findAll();
		else 
			return accountService.findByName(name);
	}
	
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferRequest request) {
		long idSender = request.getIdSender();
		long idReceiver = request.getIdReceiver();
		BigDecimal amount = request.getAmount();
		
		accountService.transferMoney(idSender, idReceiver, amount);
	}
	

}
