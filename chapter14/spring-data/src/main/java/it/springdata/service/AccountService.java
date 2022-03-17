package it.springdata.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.springdata.dao.Account;
import it.springdata.exceptions.AccountNotFoundException;
import it.springdata.repository.AccountRepository;

@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public Iterable<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public List<Account> findByName(String name) {
		return accountRepository.findByName(name);
	}
	
	@Transactional
	public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
		Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
		Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());
		
		BigDecimal newSenderAmount = sender.getAmount().subtract(amount);
		BigDecimal newReceiverAmount = receiver.getAmount().add(amount);
		
		accountRepository.changeAmount(idSender, newSenderAmount);
		accountRepository.changeAmount(idReceiver, newReceiverAmount);
	}

}
